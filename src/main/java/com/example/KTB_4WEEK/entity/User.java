package com.example.KTB_4WEEK.entity;

import com.example.KTB_4WEEK.dto.request.user.LoginRequestDto;

import java.time.LocalDateTime;

public class User {
    private long id = 0L;
    private String email = "";
    private String password = "";
    private String nickname = "";
    private String profileImage = "";
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = createdAt;
    private boolean isDeleted = false;

    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(long id, String email, String password,
                String nickname, String profileImage) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.isDeleted = false;
    }

    public User(String email, String password,
                String nickname, String profileImage) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.isDeleted = false;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setUpdatedAt(LocalDateTime now) {
        this.updatedAt = now;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", isDeleted=" + isDeleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        User user = (User) o;
        if ((user.email.equals(this.email)) && user.password.equals(this.password)) {
            return true;
        }

        return false;
    }
}
