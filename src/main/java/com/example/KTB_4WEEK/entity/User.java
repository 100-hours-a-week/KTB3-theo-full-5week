package com.example.KTB_4WEEK.entity;

import com.example.KTB_4WEEK.dto.request.user.LoginRequestDto;
import org.springframework.cglib.core.Local;

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

    public User() {
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

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public void identify(long id) {
        this.id = id;
    }

    public void updateNow() {
        this.updatedAt = LocalDateTime.now();
    }

    public void softDelete() {
        this.isDeleted = true;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updatePassword(String password) {
        this.password = password;
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
