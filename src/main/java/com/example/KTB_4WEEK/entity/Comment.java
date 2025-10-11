package com.example.KTB_4WEEK.entity;


import java.time.LocalDateTime;

public class Comment {
    private long id = 0L;
    private long postId = 0L;
    private long userId = 0L;
    private String content = "";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = createdAt;
    private boolean isDeleted = false;

    public Comment() {
    }

    public Comment(long id, long postId, long userId, String content) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }

    public Comment(long userId, long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }

    public Comment(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
