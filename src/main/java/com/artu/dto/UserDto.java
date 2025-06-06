package com.artu.dto;

import com.artu.entity.users.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;

public class UserDto {

    @Getter
    @Setter
    @ToString
    public static class LoginRequestDto {

        @NotBlank
        private String id;
        @NotBlank
        private String pw;
    }


    @Getter
    @Setter
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginResponseAuthDto {

        private String jwt;
        private User user;
    }


    @Getter
    @Setter
    @ToString
    public static class SignupRequestDto {
        private String username;
        private String password;
        private String email;
        private String nickname;
        // 필요한거 더 넣기로.
    }


    @Getter
    @Setter
    @ToString
    public static class UserFollowDto {
        private Integer followerId;
        private Integer followeeId;
    }


    @Getter
    @Setter
    @ToString
    public static class UserInquireDto {
        private Integer userNo;
        private String inquireCategory;
        private String title;
        private String contents;
        private Integer paymentId;
        private String inquiryImgUrl;
        private String inquiryState;
        private Boolean isUsed;
    }


    @Getter
    @Setter
    @ToString
    public static class UserSettingDto {
        private Integer userNo;
        private String displayColor;
        private String language;
        private Instant setAt;
        private Boolean isUsed;
    }
}
