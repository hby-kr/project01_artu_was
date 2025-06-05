package com.artu.dto;

import com.artu.entity.users.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
}
