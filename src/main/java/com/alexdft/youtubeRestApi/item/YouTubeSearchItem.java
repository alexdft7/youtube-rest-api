package com.alexdft.youtubeRestApi.item;

public class YouTubeSearchItem {

    private String title;
    private String description;
    private String thumbnails;
    private String url;

    public YouTubeSearchItem(String url, String title, String thumbnails, String description) {
        this.title=title;
        this.description=description;
        this.thumbnails=thumbnails;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
