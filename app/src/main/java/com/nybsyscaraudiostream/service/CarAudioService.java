package com.nybsyscaraudiostream.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media.MediaBrowserServiceCompat;

import com.nybsyscaraudiostream.helper.ChannelHelper;
import com.nybsyscaraudiostream.model.Channel;
import com.nybsyscaraudiostream.ui.PlayerHolder;
import com.nybsyscaraudiostream.util.AppEnums;
import com.nybsyscaraudiostream.util.Toaster;

import java.util.List;

public class CarAudioService extends MediaBrowserServiceCompat implements AudioManager.OnAudioFocusChangeListener {

    final String CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED";
    final String CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT";
    final String CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT";

    final int CONTENT_STYLE_LIST_ITEM_HINT_VALUE = 1;
    final int CONTENT_STYLE_GRID_ITEM_HINT_VALUE = 2;

    final String ROOT_ID = "root";


    private MediaSessionCompat session;
    private String lastMediaId;
    private PlayerHolder playerHolder;//should init
    private AudioManager audioManager;
    private AudioFocusRequest audioFocusRequest;

    private ConnectedReiver connectedReciever;
    private OnAudioNoisyReciever onAudioNoisyReciever;
    private Channel currentChannel;

    public CarAudioService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        //TODO should work with channel helper list
        if (currentChannel == null) {
        }
        if (audioManager == null) {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        }
        if (audioFocusRequest == null) {

        }
        if (connectedReciever == null) {
            connectedReciever = new ConnectedReiver();
        }
        if (onAudioNoisyReciever == null) {
            onAudioNoisyReciever = new OnAudioNoisyReciever();
        }
        if (session == null) {
            session = new MediaSessionCompat(this, "appAudioService");

        }
        setSessionToken(session.getSessionToken());
        session.setCallback(new MediaSessionCallback());
        if (playerHolder == null) {
            playerHolder = new PlayerHolder(this, session);
        }
        playerHolder.createPlayer();

        registerReceiver(connectedReciever, new IntentFilter("com.google.android.gms.car.media.STATUS"));
        registerReceiver(onAudioNoisyReciever, new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY));
    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        Bundle extras = new Bundle();
        extras.putBoolean(CONTENT_STYLE_SUPPORTED,true);
        extras.putInt(CONTENT_STYLE_BROWSABLE_HINT,CONTENT_STYLE_LIST_ITEM_HINT_VALUE);
        extras.putInt(CONTENT_STYLE_PLAYABLE_HINT,CONTENT_STYLE_LIST_ITEM_HINT_VALUE);
        return new BrowserRoot(ROOT_ID,extras);
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {
        Log.d("chkcarlog","root id:"+parentId);
        switch (parentId)
        {
            case ROOT_ID:
                result.sendResult(ChannelHelper.createChildrenListing(this,"Ambient"));
                break;
        /*    case AppEnums.MEDIA_ID_FAVOURITES:
                result.sendResult(ChannelHelper.createBrowsableListing(this,fa));*/
               // break;
            default:
                result.sendResult(ChannelHelper.createChildrenListing(this,parentId));
                break;
        }
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange)
        {
            case AudioManager.AUDIOFOCUS_GAIN:
                playerHolder.continuePlaying();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                playerHolder.pausePlaying();
                break;
            default:break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(connectedReciever);
        unregisterReceiver(onAudioNoisyReciever);
        playerHolder.releasePlayer();
        session.release();
    }

    private int getAudioFocus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioFocusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                    .setOnAudioFocusChangeListener(this::onAudioFocusChange)
                    .setAcceptsDelayedFocusGain(false)
                    .build();

            return audioManager.requestAudioFocus(audioFocusRequest);
        } else {
            return audioManager.requestAudioFocus(this::onAudioFocusChange, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
        }
    }

    private void abandonAudioFocus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // audioFocusRequest?.let { audioManager.abandonAudioFocusRequest(it) }
            audioManager.abandonAudioFocusRequest(audioFocusRequest);
        } else {
            audioManager.abandonAudioFocus(this::onAudioFocusChange);
        }
    }

    private class MediaSessionCallback extends MediaSessionCompat.Callback {
        private void play(String mediaId) {
            if (getAudioFocus() == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                currentChannel = ChannelHelper.getChannelForId(mediaId);
                session.setActive(true);
                lastMediaId = mediaId;
                playerHolder.startPlaying(currentChannel);

            }
        }

        @Override
        public void onPlay() {
            super.onPlay();
            play(lastMediaId);
        }

        @Override
        public void onPlayFromMediaId(String mediaId, Bundle extras) {
            super.onPlayFromMediaId(mediaId, extras);
            lastMediaId = mediaId;
            play(lastMediaId);
        }

        @Override
        public void onPlayFromSearch(String query, Bundle extras) {
            super.onPlayFromSearch(query, extras);
            if(query==null)
            {
                if(!query.isEmpty())
                {
                    play(lastMediaId);

                }
            }
            String result = ChannelHelper.searchForChannelMediaId(query);

            if(result!=null)
            {
                play(result);
            }
            else {
                playerHolder.stopPlaying();
            }

        }

        @Override
        public void onPlayFromUri(Uri uri, Bundle extras) {
            super.onPlayFromUri(uri, extras);


        }

        @Override
        public void onPause() {
            super.onPause();
            playerHolder.stopPlaying();
        }

        @Override
        public void onSkipToNext() {
            super.onSkipToNext();
            play(ChannelHelper.getNextMediaId(lastMediaId));
        }

        @Override
        public void onSkipToPrevious() {
            super.onSkipToPrevious();
            play(ChannelHelper.getPreviousMediaId(lastMediaId));
        }

        @Override
        public void onStop() {
            super.onStop();
            abandonAudioFocus();
            session.setActive(false);
            playerHolder.stopPlaying();
            stopSelf();
        }

        @Override
        public void onCustomAction(String action, Bundle extras) {
            super.onCustomAction(action, extras);
            if(action== AppEnums.CUSTOM_ACTION_FAVORITE)
            {
                Toaster.ShowText("custom action tapped to favourite");
                playerHolder.updateFavouritedState();
            }
            else {
                Toaster.ShowText("some custom action taken");
            }
        }
    }

    private class ConnectedReiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!intent.getStringExtra("media_connection_status").equals("media_connected")) {
                playerHolder.stopPlaying();
            }
        }
    }

    private class OnAudioNoisyReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AudioManager.ACTION_AUDIO_BECOMING_NOISY)) {
                playerHolder.stopPlaying();
            }
        }
    }

}
