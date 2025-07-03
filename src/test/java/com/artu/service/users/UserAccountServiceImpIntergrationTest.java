package com.artu.service.users;

import com.artu.dto.UserDto;
import com.artu.entity.users.*;
import com.artu.entity.users.activity.UserProfile;
import com.artu.entity.users.activity.UserStat;
import com.artu.repository.users.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional; // 롤백을 위함

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional // 각 테스트 메서드가 끝날 때 DB 변경사항을 롤백하여 테스트 간 독립성 보장
class UserAccountServiceImpIntergrationTest {

    @Autowired private UserRepository userRepository;
    @Autowired private UserProfileRepository userProfileRepository;
    @Autowired private UserStatRepository userStatRepository;
    @Autowired private PasswordChangeHistoryRepository passwordChangeHistoryRepository;
    @Autowired private UserImageRepository userImageRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired private UserAccountService userAccountService;

    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 1. 회원가입 테스트 (registerUser)
    @DisplayName("회원가입 통합 테스트")
    @Test
    void registerUser_Integration_Success() {

        // Given
        UserDto.SignupRequestDto requestDto = UserDto.SignupRequestDto.builder()
                .userId("testuser")
                .password("1234")
                .email("testuser@example.com")
                .name("테스트")
                .phone("010-8888-8888")
                .birth(LocalDate.of(1990, 1, 1))
                .gender(String.valueOf(UserProfile.Gender.M))
                .nickname("testnick")
                .build();

        // When
        User savedUser = userAccountService.registerUser(requestDto);

        // Then
        assertThat(savedUser).isNotNull(); // user 객체가 null이 아님
        assertThat(savedUser.getUserNo()).isNotNull(); // userNo가 DB에 의해 할당되었는지
        assertThat(savedUser.getUserId()).isEqualTo("testuser"); // user ID 일치
        // DB에서 실제로 데이터가 저장되었는지 검증
        Optional<User> foundUser = userRepository.findByUserId("testuser");
        assertThat(foundUser).isPresent(); // User 엔티티 존재
        assertThat(passwordEncoder.matches("1234", foundUser.get().getPassword())).isTrue(); // 비밀번호 암호화 및 일치 검증

        Optional<UserProfile> foundProfile = userProfileRepository.findById(savedUser.getUserNo());
        assertThat(foundProfile).isPresent(); // UserProfile 엔티티 존재
        assertThat(foundProfile.get().getEmail()).isEqualTo("testuser@example.com");

        Optional<UserStat> foundStat = userStatRepository.findById(savedUser.getUserNo());
        assertThat(foundStat).isPresent(); // UserStat 엔티티 존재
        assertThat(foundStat.get().getUserNo()).isEqualTo(savedUser.getUserNo()); // 번호가 맞는지.
        // assertThat(foundStat.get().getPostCount()).isEqualTo(0); // 기본값 확인

        // 비밀번호 변경 이력도 생성되었는지 확인
        assertThat(passwordChangeHistoryRepository.findByUserNo(savedUser.getUserNo())).isNotEmpty();
    }

//
//    @DisplayName("회원가입 통합 테스트 실패: 중복 ID")
//    @Test
//    void registerUser_Integration_Fail_DuplicateUserId() {
//        // Given: 미리 사용자 등록하여 중복 상황 생성
//        User existingUser = User.builder()
//                .userId("dupuser").password("pass").email("dup@example.com")
//                .name("중복").phone("010-9999-8888").birth(LocalDate.of(1990, 1, 1))
//                .gender("FEMALE").nickname("중복닉").role(User.UserRole.USER).isUsed(true).createdAt(LocalDateTime.now()).build();
//        userRepository.save(existingUser); // 실제 DB에 저장
//
//        UserDto.SignupRequestDto requestDto = UserDto.SignupRequestDto.builder().userId("dupuser").build(); // 중복 ID로 요청
//
//        // When & Then
//        assertThatThrownBy(() -> userAccountService.registerUser(requestDto))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("이미 존재하는 사용자 ID입니다.");
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 2. 프로필 조회 테스트 (getUserAccountProfile)
//
//    @DisplayName("프로필 조회 통합 테스트 성공: 사용자 및 모든 연관 프로필 존재 시")
//    @Test
//    void getUserAccountProfile_Integration_Success() {
//        // Given: 사용자 및 모든 연관 프로필 더미 데이터 생성 및 저장
//        User user = User.builder().userNo(99).userId("profileuser").password("encoded").email("profile@example.com")
//                .name("프로필").phone("010-7777-8888").birth(LocalDate.of(1980, 3, 15)).gender("FEMALE")
//                .nickname("프로필닉").role(User.UserRole.USER).isUsed(true).createdAt(LocalDateTime.now()).build();
//        userRepository.save(user);
//
//        UserProfile userProfile = UserProfile.builder().userNo(user.getUserNo()).email("profile@example.com")
//                .name("프로필").phone("010-7777-8888").birth(LocalDate.of(1980, 3, 15)).gender("FEMALE")
//                .nickname("프로필닉").isUsed(true).build();
//        userProfileRepository.save(userProfile);
//
//        UserStat userStat = new UserStat(); userStat.setUserNo(user.getUserNo()); userStat.setFollowerCount(5); userStat.setFollowingCount(10); userStat.setPostCount(3); userStat.setIsUsed(true);
//        userStatRepository.save(userStat);
//
//        UserImg userImg = UserImg.builder().prfImgId(1).userNo(user.getUserNo()).prfImgUrl("http://img.com/profile.jpg").createdAt(LocalDateTime.now()).isUsed(true).build();
//        userImgRepository.save(userImg);
//
//        // When
//        Optional<UserDto.UserProfileResponseDto> result = userAccountService.getUserAccountProfile("profileuser");
//
//        // Then
//        assertThat(result).isPresent(); // 결과가 존재해야 함
//        UserDto.UserProfileResponseDto dto = result.get();
//        assertThat(dto.getUserId()).isEqualTo("profileuser");
//        assertThat(dto.getEmail()).isEqualTo("profile@example.com");
//        assertThat(dto.getName()).isEqualTo("프로필");
//        assertThat(dto.getNickname()).isEqualTo("프로필닉");
//        assertThat(dto.getFollowerCount()).isEqualTo(5); // UserStat 정보 확인
//        assertThat(dto.getFollowingCount()).isEqualTo(10);
//        assertThat(dto.getPostCount()).isEqualTo(3);
//        assertThat(dto.getProfileImageUrl()).isEqualTo("http://img.com/profile.jpg"); // UserImg 정보 확인
//    }
//
//    @DisplayName("프로필 조회 통합 테스트 실패: 사용자 없음")
//    @Test
//    void getUserAccountProfile_Integration_Fail_UserNotFound() {
//        // Given: DB에 해당 user_id의 사용자 없음
//
//        // When
//        Optional<UserDto.UserProfileResponseDto> result = userAccountService.getUserAccountProfile("nonexistentuser");
//
//        // Then
//        assertThat(result).isNotPresent(); // 결과가 없어야 함
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 3. 회원 탈퇴 테스트 (withdrawAccount)
//
//    @DisplayName("회원 탈퇴 통합 테스트 성공: 계정 논리적 삭제")
//    @Test
//    void withdrawAccount_Integration_Success() {
//        // Given: 활성화된 사용자 및 관련 프로필 데이터 생성
//        User user = User.builder().userNo(100).userId("withdrawuser").password(passwordEncoder.encode("correctPass")).email("withdraw@example.com")
//                .name("탈퇴").phone("010-6666-7777").birth(LocalDate.of(1990, 1, 1)).gender("MALE")
//                .nickname("탈퇴닉").role(User.UserRole.USER).isUsed(true).createdAt(LocalDateTime.now()).build();
//        userRepository.save(user);
//
//        UserProfile userProfile = UserProfile.builder().userNo(user.getUserNo()).email("withdraw@example.com")
//                .name("탈퇴").phone("010-6666-7777").birth(LocalDate.of(1990, 1, 1)).gender("MALE")
//                .nickname("탈퇴닉").isUsed(true).build();
//        userProfileRepository.save(userProfile);
//
//        UserStat userStat = new UserStat(); userStat.setUserNo(user.getUserNo()); userStat.setIsUsed(true);
//        userStatRepository.save(userStat);
//
//        UserImg userImg = UserImg.builder().prfImgId(2).userNo(user.getUserNo()).prfImgUrl("http://img.com/withdraw.jpg").createdAt(LocalDateTime.now()).isUsed(true).build();
//        userImgRepository.save(userImg);
//
//        // When
//        userAccountService.withdrawAccount("withdrawuser", "correctPass");
//
//        // Then
//        // User 엔티티 상태 확인
//        Optional<User> withdrawnUser = userRepository.findByUserId("withdrawuser");
//        assertThat(withdrawnUser).isPresent();
//        assertThat(withdrawnUser.get().getIsUsed()).isFalse(); // isUsed가 false로 변경되었는지
//        assertThat(withdrawnUser.get().getDropoutAt()).isNotNull(); // 탈퇴 시간이 기록되었는지
//        assertThat(withdrawnUser.get().getMemo()).isEqualTo("유저에 의한 탈퇴"); // 메모 확인
//
//        // 연관 엔티티들의 isUsed 상태 확인
//        assertThat(userProfileRepository.findById(user.getUserNo()).get().getIsUsed()).isFalse();
//        assertThat(userStatRepository.findById(user.getUserNo()).get().getIsUsed()).isFalse();
//        assertThat(userImgRepository.findByUserNo(user.getUserNo()).get().getIsUsed()).isFalse();
//    }
//
//    @DisplayName("회원 탈퇴 통합 테스트 실패: 비밀번호 불일치")
//    @Test
//    void withdrawAccount_Integration_Fail_PasswordMismatch() {
//        // Given: 사용자 및 관련 프로필 데이터 생성
//        User user = User.builder().userNo(101).userId("mismatchuser").password(passwordEncoder.encode("correctPass")).email("mismatch@example.com")
//                .name("불일치").phone("010-1111-2222").birth(LocalDate.of(1990, 1, 1)).gender("MALE")
//                .nickname("불일치닉").role(User.UserRole.USER).isUsed(true).createdAt(LocalDateTime.now()).build();
//        userRepository.save(user);
//
//        // When & Then
//        assertThatThrownBy(() -> userAccountService.withdrawAccount("mismatchuser", "wrongPass"))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("비밀번호가 일치하지 않습니다.");
//
//        // 변경이 일어나지 않았는지 확인
//        assertThat(userRepository.findByUserId("mismatchuser").get().getIsUsed()).isTrue();
//    }
}