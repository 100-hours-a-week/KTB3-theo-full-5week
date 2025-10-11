package com.example.KTB_4WEEK.dto.response.user;


public class RegistUserResponseDto {
    private long id = 0L;

    public RegistUserResponseDto(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id : " + this.id;
    }

    public long getId() {
        return id;
    }
}
