package com.example.KTB_4WEEK.dto.request.user;

public class RegistUserRequestDto {
    private String email;
    private String password;
    private String nickname;
    private String profileImage;

    public RegistUserRequestDto() {
    }

    public String getEmail() {
        return email;
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

    public String getProfileImage() {
        return profileImage;
    }

}
