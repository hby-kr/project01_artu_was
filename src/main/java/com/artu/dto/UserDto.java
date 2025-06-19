package com.artu.dto;

import com.artu.entity.users.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate; // birth 필드 추가를 위해 임포트

public class UserDto {

    // 1. 로그인 요청 DTO
    @Getter
    @Setter
    @ToString
    public static class LoginRequestDto {
        @NotBlank
        private String userId;
        @NotBlank
        private String password;
    }

    // 2. 로그인 응답 (인증) DTO
    @Getter
    @Setter
    @ToString
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginResponseAuthDto {
        private String jwt;
        // private User user; // 실제 User 엔티티를 보내는 것은 부적절하다고 판단. 필요한 정보만 담은 DTO로 변경
        private String userId; // 사용자의 식별 아이디
        private String name; // 사용자의 이름 (환영 메시지 등에 활용)
        private String role; // 사용자의 권한 (ENUM 값을 String으로 전달)
        private String nickname;
        private String profileImageUrl; // 사용자의 프로필 이미지 URL (선택적)
    }

    // 3. 회원가입 요청 DTO
    @Getter
    @Setter
    @ToString
    @Builder // 빌더 패턴 사용을 위해 추가
    @AllArgsConstructor // 빌더 패턴 사용 시 필요
    @NoArgsConstructor // 기본 생성자 필요
    public static class SignupRequestDto {
        @NotBlank
        private String userId;
        @NotBlank
        private String password;
        @NotBlank
        private String email;
        @NotBlank
        private String name;
        @NotBlank
        private String phone;
        @NotBlank
        private LocalDate birth;
        @NotBlank
        private String gender;
        private String nickname;
    }

    // 4. OAuth 사용자 DTO
    @Getter
    @Setter
    @ToString
    public static class OAuthUser {
        @NotBlank
        private String email;
        @NotBlank
        private String name;
        @NotBlank
        private String oauth;
        // 추가 더 넣을 것.
    }

    // 6. 비밀번호 변경 요청 DTO  (로그인 상태에서 회원정보 들어와서)

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PasswordChangeRequestDto {
        @NotBlank
        private String currentPassword;
        @NotBlank
        private String newPassword;
    }

    // 7. 비밀번호 재설정 요청 DTO (비밀번호 모르는 상태. 아이디/이메일로 본인 확인 후 새 비밀번호 설정)
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PasswordResetRequestDto {
        @NotBlank
        private String userId;
        @NotBlank
        private String email;
        @NotBlank // 재설정할 비밀번호는 필수
        private String newPassword;
    }

    // 8. 아이디 찾기 요청 DTO
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserIdFindRequestDto {
        @NotBlank
        private String email;
    }
    // 9. 아이디 찾기 응답 DTO
    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserIdFindResponseDto {
        private String userId;
    }

    // 10. 사용자 프로필 응답 DTO (클라이언트에게 반환할 상세 프로필 정보)
    // 로그인 -> 마이페이지 가서  내정보 볼때.
    @Getter
    @Setter
    @ToString
    @Builder // 빌더 패턴 사용을 위해 추가
    @AllArgsConstructor // 빌더 패턴 사용 시 필요
    @NoArgsConstructor // 기본 생성자 필요
    public static class UserProfileResponseDto {
        private String userId;
        private String email;
        private String name;
        private String phone;
        private LocalDate birth;
        private String gender;
        private int followingCount; // user_stats 정보
        private int followerCount;  // user_stats 정보
        private int postCount;      // user_stats 정보
        private String nickname;
        private String profileImageUrl; // user_img 정보
        // 기타 필요 정보 (예: 생성일, 역할 등) 추가 가능
    }
}