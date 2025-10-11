package com.example.KTB_4WEEK.entity;


import java.time.LocalDateTime;

public class Post {
    // id ~ category : User가 조회 수정 가능
    private long id = 0L;
    private long authorId = 0L;
    private String title = "";
    private String article = "";
    private String articleImage = "";
    private PostCategory category = PostCategory.NONE;

    // User Invisible data, 서버 내부적으로 값 설정
    private int hit = 0;
    private int like = 0;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = this.createdAt;
    private boolean isDeleted = false;

    public Post() {};

    public Post(long id, long authorId, String title, String article, PostCategory category, String articleImage) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.article = article;
        this.category = category;
        this.articleImage = articleImage;

    }

    public Post(long authorId, String title, String article, String articleImage, PostCategory category) {
        this.authorId = authorId;
        this.title = title;
        this.article = article;
        this.category = category;
        this.articleImage = articleImage;

    }

    public Post(String title, String article, String articleImage, PostCategory category) {
        this.title = title;
        this.article = article;
        this.articleImage = articleImage;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public PostCategory getCategory() {
        return category;
    }

    public void setCategory(PostCategory category) {
        this.category = category;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public void setArticleImage(String articleImage) {
        this.articleImage = articleImage;
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

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", articleImage='" + articleImage + '\'' +
                ", category=" + category +
                ", hit=" + hit +
                ", like=" + like +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public int increaseHit() {
        return ++this.hit;
    }

    public int increaseLike() {
        return ++this.like;
    }
}
