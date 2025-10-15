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

    public Post() {
    }

    ;

    public Post(long authorId, String title, String article, String articleImage, PostCategory category) {
        this.authorId = authorId;
        this.title = title;
        this.article = article;
        this.category = category;
        this.articleImage = articleImage;

    }

    public long getId() {
        return id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getArticle() {
        return article;
    }

    public PostCategory getCategory() {
        return category;
    }

    public int getHit() {
        return hit;
    }

    public int getLike() {
        return like;
    }

    public String getArticleImage() {
        return articleImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void identify(long id) {
        identify(id);
    }
    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateArticle(String article) {
        this.article = article;
    }

    public void updateArticleImage(String articleImage) {
        this.articleImage = articleImage;
    }

    public void updateCategory(PostCategory category) {
        this.category = category;
    }

    public void updateNow() {
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.isDeleted = true;
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
