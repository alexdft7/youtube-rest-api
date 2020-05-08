package com.alexdft.youtubeRestApi.item;

public class YouTubeCommentItem {

    private String Id;
    private String authorDisplayName;
    private String commentContent;
    private String likeCount;
    private String publishingTime;

    public YouTubeCommentItem(String Id, String authorDisplayName, String commentContent, String likeCount, String publishingTime) {
        this.Id=Id;
        this.authorDisplayName=authorDisplayName;
        this.commentContent=commentContent;
        this.likeCount=likeCount;
        this.publishingTime=publishingTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getPublishingTime() {
        return publishingTime;
    }

    public void setPublishingTime(String publishingTime) {
        this.publishingTime = publishingTime;
    }
}
