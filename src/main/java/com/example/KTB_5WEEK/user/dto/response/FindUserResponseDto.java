package com.example.KTB_5WEEK.user.dto.response;

import com.example.KTB_5WEEK.app.util.DateTimePattern;
import com.example.KTB_5WEEK.user.entity.User;

import java.time.format.DateTimeFormatter;

public class FindUserResponseDto {
    private long id;
    private String email;
    private String nickname;
    private String profileImage;
    private String created_at;
    private String updated_at;

    public static FindUserResponseDto toDto(User user) {
        FindUserResponseDto dto = new FindUserResponseDto();
        dto.id = user.getId();
        dto.email = user.getEmail();
        dto.nickname = user.getNickname();
        dto.profileImage = user.getProfileImage();
        dto.created_at = user.getCreatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        dto.updated_at = user.getUpdatedAt()
                .format(DateTimeFormatter.ofPattern(DateTimePattern.DEFAULT_DATE_TIME));
        return dto;
    }
}
