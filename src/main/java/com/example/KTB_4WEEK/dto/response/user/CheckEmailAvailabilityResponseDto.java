package com.example.KTB_4WEEK.dto.response.user;

public class CheckEmailAvailabilityResponseDto {
    private String email;
    private boolean isAvailable;

    public CheckEmailAvailabilityResponseDto(String email, boolean isAvailable) {
        this.email = email;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
