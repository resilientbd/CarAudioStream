package com.nybsyscaraudiostream.model;

public class Channel {
    private String mediaId;
    private String title;
    private int imageRes;
    private int id;

    public Channel() {
    }

    public Channel(String mediaId, String title, int imageRes) {
        this.mediaId = mediaId;
        this.title = title;
        this.imageRes = imageRes;

    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "mediaId='" + mediaId + '\'' +
                ", title='" + title + '\'' +
                ", imageRes=" + imageRes +
                ", id=" + id +
                '}';
    }
}
