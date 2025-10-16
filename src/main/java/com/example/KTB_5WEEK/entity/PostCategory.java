package com.example.KTB_5WEEK.entity;

public enum PostCategory {
    COMMUNITY("소통방"),
    INFO_SHARE("정보공유"),
    COUNSELING("고민상담"),
    NONE("NONE");

    private final String category;

    PostCategory(String category) {
        this.category = category;
    }
}
