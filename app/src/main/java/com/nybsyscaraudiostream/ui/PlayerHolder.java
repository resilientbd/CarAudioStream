package com.nybsyscaraudiostream.ui;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;

import com.google.android.exoplayer2.SimpleExoPlayer;

import static android.media.session.PlaybackState.STATE_STOPPED;

public class PlayerHolder {
    private Context context;
    private MediaSessionCompat session;

    private String listenerKey;

    private SimpleExoPlayer player;
    private int currentState = STATE_STOPPED;

    public PlayerHolder(Context context, MediaSessionCompat session) {
        this.context = context;
        this.session = session;
    }


}
