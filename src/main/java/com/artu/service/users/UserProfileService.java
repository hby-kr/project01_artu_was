package com.artu.service.users;

import com.artu.dto.UserDto;

import java.util.Optional;

public interface UserProfileService {
    // 사용자 프로필 정보 관리 (프로필 조회/수정, 프로필 이미지 관리, 관심사 설정, 알림/환경 설정 등)

    // 마이페이지
    // 특정 사용자 ID로 본인의 계정 상세 프로필 정보 모두를 조회합니다.
    Optional<UserDto.UserProfileResponseDto> getUserAccountInfo(String userId);


}
