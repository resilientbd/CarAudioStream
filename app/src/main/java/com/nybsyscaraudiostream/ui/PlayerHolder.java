package com.nybsyscaraudiostream.ui;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.nybsyscaraudiostream.model.Channel;

import static android.media.session.PlaybackState.STATE_STOPPED;

public class PlayerHolder implements Player.EventListener {
    private Context context;
    private MediaSessionCompat session;

    private String listenerKey;

    private SimpleExoPlayer player;
    private int currentState = STATE_STOPPED;

    public PlayerHolder(Context context, MediaSessionCompat session) {
        this.context = context;
        this.session = session;
    }
    public void createPlayer(){
        setPlaybackState(STATE_STOPPED,true);
       // player = ExoPlayerFactory.newSimpleInstance
    }
    public void startPlaying(Channel channel)
    {

    }
    public void continuePlaying()
    {

    }
    public void stopPlaying()
    {

    }
    public void releasePlayer()
    {

    }
    public void updateFavouritedState()
    {

    }
    private void setPlaybackState(int state,Boolean isInitializing){

    }
    @Override
    public void onTimelineChanged(Timeline timeline, @Nullable Object manifest, int reason) {

    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {

    }

    @Override
    public void onLoadingChanged(boolean isLoading) {

    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

    }

    @Override
    public void onRepeatModeChanged(int repeatMode) {

    }

    @Override
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }

    @Override
    public void onPositionDiscontinuity(int reason) {

    }

    @Override
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {

    }

    @Override
    public void onSeekProcessed() {

    }

    public void pausePlaying() {
    }
}
