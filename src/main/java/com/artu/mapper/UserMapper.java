package com.artu.mapper;

import com.artu.dto.UserDto;
import com.artu.entity.users.User;
import com.artu.entity.users.activity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.LocalDate;

@Mapper(componentModel = "spring") // Spring 컴포넌트 모델 사용
public interface UserMapper {

    // UserDto.LoginRequestDto -> User 엔터티 매핑
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "userNo", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "oauth", ignore = true)
    @Mapping(target = "isUsed", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "dropoutAt", ignore = true)
    @Mapping(target = "memo", ignore = true)
    User toUser(UserDto.LoginRequestDto loginRequestDto);

    // User 및 UserProfile 엔터티 -> UserDto.LoginResponseAuthDto 매핑
    @Mapping(target = "jwt", ignore = true) // JWT는 서비스에서 설정
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "role", source = "user.role")
    @Mapping(target = "name", source = "userProfile.name")
    @Mapping(target = "nickname", source = "userProfile.nickname")
    @Mapping(target = "profileImageUrl", ignore = true) // 프로필 이미지 URL은 서비스에서 설정
    UserDto.LoginResponseAuthDto toLoginResponseAuthDto(User user, UserProfile userProfile);

    // UserDto.SignupRequestDto -> User 엔터티 매핑
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "phone", ignore = true)
    @Mapping(target = "birth", ignore = true)
    @Mapping(target = "gender", ignore = true)
    @Mapping(target = "nickname", ignore = true)
    @Mapping(target = "userNo", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "oauth", ignore = true)
    @Mapping(target = "isUsed", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "dropoutAt", ignore = true)
    @Mapping(target = "memo", ignore = true)
    User toUser(UserDto.SignupRequestDto signupRequestDto);

    // UserDto.SignupRequestDto -> UserProfile 엔터티 매핑
    @Mapping(target = "userNo", ignore = true)
    @Mapping(target = "nickname", source = "nickname")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "birth", source = "birth")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "isUsed", ignore = true)
    UserProfile toUserProfile(UserDto.SignupRequestDto signupRequestDto);

    // UserDto.OAuthUser -> User 엔터티 매핑
//    @Mapping(target = "email", ignore = true)
//    @Mapping(target = "name", ignore = true)
//    @Mapping(target = "nickname", ignore = true)
//    @Mapping(target = "oauth", source = "oauth")
//    @Mapping(target = "userId", ignore = true)
//    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "userNo", ignore = true)
//    @Mapping(target = "role", ignore = true)
//    @Mapping(target = "isUsed", ignore = true)
//    @Mapping(target = "createdAt", ignore = true)
//    @Mapping(target = "dropoutAt", ignore = true)
//    @Mapping(target = "memo", ignore = true)
//    User toUser(UserDto.OAuthUser oauthUser);

    // User 및 UserProfile 엔터티 -> UserDto.UserProfileResponseDto 매핑
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "email", source = "userProfile.email")
    @Mapping(target = "name", source = "userProfile.name")
    @Mapping(target = "phone", source = "userProfile.phone")
    @Mapping(target = "birth", source = "userProfile.birth")
    @Mapping(target = "gender", source = "userProfile.gender")
    @Mapping(target = "nickname", source = "userProfile.nickname")
    @Mapping(target = "followingCount", ignore = true)
    @Mapping(target = "followerCount", ignore = true)
    @Mapping(target = "postCount", ignore = true)
    @Mapping(target = "profileImageUrl", ignore = true)
    UserDto.UserProfileResponseDto toUserProfileResponseDto(User user, UserProfile userProfile);

}