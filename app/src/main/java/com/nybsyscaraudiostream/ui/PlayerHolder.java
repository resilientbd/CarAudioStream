package com.nybsyscaraudiostream.ui;

import android.content.Context;
import android.drm.DrmStore;
import android.graphics.BitmapFactory;
import android.media.AudioTrack;
import android.net.Uri;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.icy.IcyInfo;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.nybsyscaraudiostream.R;
import com.nybsyscaraudiostream.model.Channel;
import com.nybsyscaraudiostream.util.AppEnums;

import static android.media.session.PlaybackState.STATE_STOPPED;

public class PlayerHolder implements Player.EventListener {
    private Context context;
    private MediaSessionCompat session;
    private Channel channel;
    private String listenerKey;

    private SimpleExoPlayer player;
    private int currentState = STATE_STOPPED;

    public PlayerHolder(Context context, MediaSessionCompat session) {
        this.context = context;
        this.session = session;
    }

    public void createPlayer() {
        setPlaybackState(STATE_STOPPED, true);
        player = ExoPlayerFactory.newSimpleInstance(context, new DefaultTrackSelector());
        player.addListener(this);
    }

    public void startPlaying(Channel channel) {
        this.channel = channel;
        MetadataOutput metadataOutput = new MetadataOutput() {
            @Override
            public void onMetadata(Metadata metadata) {
                for (int i = 0; i < metadata.length(); i++) {
                    Metadata.Entry entry = metadata.get(i);
                    if (entry instanceof IcyInfo) {
                        String artistTitle = "";
                        String artist = "";
                        String title = "";
                        if (title != null) {
                            if (!title.isEmpty()) {

                                String[] titleSplit = ((IcyInfo) entry).title.split(" - ");
                                artist = titleSplit[0] != null ? titleSplit[0] : "";
                                title = titleSplit[1] != null ? titleSplit[1] : "";

                                session.setMetadata(new MediaMetadataCompat.Builder()
                                        .putString(MediaMetadataCompat.METADATA_KEY_ARTIST, artist)
                                        .putString(MediaMetadataCompat.METADATA_KEY_TITLE, title)
                                        .putString(MediaMetadataCompat.METADATA_KEY_ALBUM, "${channel.title} DI.FM")
                                        .putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART,
                                                BitmapFactory.decodeResource(context.getResources(), channel.getImageRes()))
                                        .build());

                            }
                        }
                    }
                }
            }
        };
        MediaItem mediaItem = null;
        Uri uri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");
        String userAgent = Util.getUserAgent(context, ""+context.getApplicationInfo().name);


        try{
            mediaItem = MediaItem.fromUri(uri);
            MediaSource mediaSource = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(context, userAgent))
                    .createMediaSource(mediaItem);
            if (player != null) {
                player.addMetadataOutput(metadataOutput);
                player.prepare(mediaSource);
                player.setPlayWhenReady(true);
            }

        }
        catch (Exception e)
        {
            Log.e("carstreamlog","exception exoplayer:"+e.getMessage());
        }

    }

    public void continuePlaying() {
        if (player != null) {
            player.setPlayWhenReady(true);
        }
    }

    public void stopPlaying() {
        if (player != null) {
            player.setPlayWhenReady(false);
        }
    }

    public void releasePlayer() {
        setPlaybackState(STATE_STOPPED, false);
        if (player != null) {
            player.removeListener(this);
            player.release();
            player = null;
        }
    }

    public void updateFavouritedState() {
        setPlaybackState(currentState, false);
    }

    private void setPlaybackState(int state, Boolean isInitializing) {
        currentState = state;
        if (isInitializing) {
            session.setPlaybackState(new PlaybackStateCompat.Builder()
                    .setState(state, 0, 0f)
                    .build());
        } else {
            int favouriteDrawableRes = R.drawable.ic_round_star_border_24dp;
            PlaybackStateCompat.CustomAction customAction = new PlaybackStateCompat.CustomAction
                    .Builder(AppEnums.CUSTOM_ACTION_FAVORITE, context.getString(R.string.action_favourite_name), favouriteDrawableRes)
                    .build();
            session.setPlaybackState(new PlaybackStateCompat.Builder()
                    .setState(state, 0, 0f)
                    .setActions(PlaybackStateCompat.ACTION_PLAY_PAUSE)
                    // .addCustomAction(customAction)
                    .build());

        }
    }

    @Override
    public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {
        //TODO not implemented
    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        //TODO not implemented
    }

    @Override
    public void onLoadingChanged(boolean isLoading) {
        if(isLoading)

        {
            setPlaybackState(PlaybackStateCompat.STATE_BUFFERING,false);
        }
        else {
            setPlaybackState(PlaybackStateCompat.STATE_PLAYING,false);
        }
    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        //TODO not implemented
    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {
        //TODO not implemented
    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
        //TODO not implemented
    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {
            setPlaybackState(PlaybackStateCompat.STATE_ERROR,false);
    }

    @Override
    public void onPositionDiscontinuity(int reason) {
        //TODO not implemented
    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        //TODO not implemented
    }

    @Override
    public void onSeekProcessed() {

    }

    public void pausePlaying() {
    }
}
