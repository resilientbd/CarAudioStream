package com.nybsyscaraudiostream.service;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media.MediaBrowserServiceCompat;

import java.util.List;

public class CarAudioService extends MediaBrowserServiceCompat {

    final String CONTENT_STYLE_SUPPORTED = "android.media.browse.CONTENT_STYLE_SUPPORTED";
    final String CONTENT_STYLE_BROWSABLE_HINT = "android.media.browse.CONTENT_STYLE_BROWSABLE_HINT";
    final String CONTENT_STYLE_PLAYABLE_HINT = "android.media.browse.CONTENT_STYLE_PLAYABLE_HINT";

    final int CONTENT_STYLE_LIST_ITEM_HINT_VALUE = 1;
    final int CONTENT_STYLE_GRID_ITEM_HINT_VALUE = 2;

    private MediaSessionCompat session;
    private String lastMediaId;
    //playerHolder
    private AudioManager audioManager;
    private AudioFocusRequest audioFocusRequest;

    //connectedReciever
    //onAudioNoisyReciever
    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        return null;
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {

    }
}
