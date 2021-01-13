package com.nybsyscaraudiostream.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media.MediaBrowserServiceCompat;

import com.nybsyscaraudiostream.ui.PlayerHolder;

import java.util.List;

public class CarAudioService extends MediaBrowserServiceCompat {

    final String CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED";
    final String CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT";
    final String CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT";

    final int CONTENT_STYLE_LIST_ITEM_HINT_VALUE = 1;
    final int CONTENT_STYLE_GRID_ITEM_HINT_VALUE = 2;

    private MediaSessionCompat session;
    private String lastMediaId;
    private PlayerHolder playerHolder;//should init
    private AudioManager audioManager;
    private AudioFocusRequest audioFocusRequest;

    private ConnectedReiver connectedReciever;
    private OnAudioNoisyReciever onAudioNoisyReciever;

    public CarAudioService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (audioManager == null) {

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
        session.setCallback(new MediaSessionCompat.Callback() {
        });
        if (playerHolder == null) {
            playerHolder = new PlayerHolder(this, session);
        }
        playerHolder.createPlayer();

        registerReceiver(connectedReciever,new IntentFilter("com.google.android.gms.car.media.STATUS"));
        registerReceiver(onAudioNoisyReciever,new IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY));
    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        return null;
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {

    }

    private class ConnectedReiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (!intent.getStringExtra("media_connection_status").equals("media_connected")) {
                playerHolder.stopPlayer();
            }
        }
    }

    private class OnAudioNoisyReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(AudioManager.ACTION_AUDIO_BECOMING_NOISY)) {
                playerHolder.stopPlayer();
            }
        }
    }
}
