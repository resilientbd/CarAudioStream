package com.nybsyscaraudiostream.helper;


import android.content.Context;
import android.net.Uri;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaDescriptionCompat;

import com.nybsyscaraudiostream.R;
import com.nybsyscaraudiostream.model.Channel;
import com.nybsyscaraudiostream.util.AppEnums;
import com.nybsyscaraudiostream.util.Toaster;

import java.util.ArrayList;
import java.util.List;

public class ChannelHelper {
    private List<Channel> currentChannelList;

    public ChannelHelper(List<Channel> currentChannelList) {
        this.currentChannelList = currentChannelList;
    }

    public List<MediaItem> createBrowsableListing(Context context) {
        List<MediaItem> mediaDescListing = new ArrayList<>();
        Uri iconUri = Uri.parse("android.resource://io.github.markspit93.autotechno/drawable/ic_round_star_24dp");
        MediaDescriptionCompat favouritesDesc = new MediaDescriptionCompat.Builder()
                .setMediaId(AppEnums.MEDIA_ID_FAVOURITES)
                .setTitle(context.getResources().getString(R.string.favourites))
                .setIconUri(iconUri)
                .build();

        mediaDescListing.add(new MediaItem(favouritesDesc, MediaItem.FLAG_BROWSABLE));
        return mediaDescListing;
    }

    public List<MediaItem> createChildrenListing(Context context, String category) {
        List<MediaItem> mediaDescListing = new ArrayList<>();
        return mediaDescListing;
    }

    public List<MediaItem> createFavouriteListing(Context context, List<Channel> favouriteChannels) {
        List<MediaItem> mediaDescListing = new ArrayList<>();
        return mediaDescListing;
    }

    public Channel getChannelForId(String mediaId) {
        return currentChannelList.get(0);
    }

    public String getNextMediaId(String currentMediaId) {
        // getChannelForId(currentMediaId)==currentChannelList.
        // currentChannelList.get(.)
        try {
            int index = getIndex(currentChannelList, currentMediaId);
            if (index == -1) {
                Toaster.ShowText("Something went wrong!");
                return null;
            } else {
                if (index == currentChannelList.size() - 1) {
                    return currentChannelList.get(index).getMediaId();
                } else {
                    return currentChannelList.get(index + 1).getMediaId();
                }
            }
        } catch (Exception e) {
            Toaster.ShowText("Exception:" + e.getMessage());
            return null;
        }

    }

    public String getPreviousMediaId(String currentMediaId) {
        // getChannelForId(currentMediaId)==currentChannelList.
        // currentChannelList.get(.)
        try {
            int index = getIndex(currentChannelList, currentMediaId);
            if (index == -1) {
                Toaster.ShowText("Something went wrong!");
                return null;
            } else {
                if (index == 0) {
                    return currentChannelList.get(index).getMediaId();
                } else {
                    return currentChannelList.get(index - 1).getMediaId();
                }
            }
        } catch (Exception e) {
            Toaster.ShowText("Exception:" + e.getMessage());
            return null;
        }

    }

    public String searchForChannelMediaId(String query) {
        if (currentChannelList != null) {
            String mediaId = null;
            for (int i = 0; i < currentChannelList.size(); i++) {
                if (currentChannelList.get(i).getMediaId() == query) {
                    mediaId = currentChannelList.get(i).getMediaId();
                    break;
                }
            }
            return mediaId;
        } else {
            return null;
        }
    }

    private int getIndex(List<Channel> channelList, String mediaId) {
        if (channelList != null) {
            int index = 0;
            for (int i = 0; i < channelList.size(); i++) {
                if (channelList.get(i).getMediaId() == mediaId) {
                    index = i;
                    break;
                }
            }
            return index;
        } else {
            return -1;
        }
    }

    private int getLastIndex(List list) {
        if (list != null) {
            return list.size() - 1;
        } else return -1;
    }
}
