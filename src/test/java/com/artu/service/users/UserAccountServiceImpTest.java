//package com.artu.service.users;
//import com.artu.dto.UserDto;
//import com.artu.entity.users.*; // User, UserProfile, UserStat, PasswordChangeHistory
//import com.artu.entity.users.activity.UserProfile;
//import com.artu.entity.users.activity.UserStat;
//import com.artu.repository.users.*; // All repositories
//import com.artu.mapper.UserMapper; // UserMapper
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//
//// 복잡한 비즈니스 규칙, 외부 서비스 연동, 특정 값의 계산/변환 등이 핵심인 시나리오(예: 로그인, 비밀번호 변경, 조회 후 마스킹)는 단위 테스트가 빠르고 효율적임.
//// 그러므로 실제 DB 연결 없이 순수하게 서비스의 비즈니스 로직만 검증하기 위해 가짜(Mock) 레포지토리를 사용
//@ExtendWith(MockitoExtension.class)
//class UserAccountServiceImpTest {
//
//
//    @Mock private UserRepository userRepository;
//    @Mock private UserProfileRepository userProfileRepository;
//    @Mock private UserStatRepository userStatRepository;
//    @Mock private PasswordChangeHistoryRepository passwordChangeHistoryRepository;
//    @Mock private UserImgRepository userImgRepository; // 서비스 필드이므로 Mock 필요
//    @Mock private UserMapper userMapper;
//    @Mock private PasswordEncoder passwordEncoder;
//
//    @InjectMocks private UserAccountService userAccountService;
//
//    // 테스트용 더미 데이터
//    private User testUser;
//    private UserProfile testUserProfile;
//    private UserStat testUserStat;
//
//    @BeforeEach
//    void setUp() {
//        testUser = User.builder()
//                .userNo(1).userId("testuser").password("encodedPass").email("test@example.com")
//                .name("테스트").phone("01012345678").birth(LocalDate.of(2000, 1, 1))
//                .gender("남성").nickname("테스트닉").role(User.UserRole.USER).isUsed(true)
//                .createdAt(LocalDateTime.now()).build();
//
//        testUserProfile = UserProfile.builder()
//                .userNo(1).email("test@example.com").name("테스트").phone("01012345678")
//                .birth(LocalDate.of(2000, 1, 1)).gender("남성").nickname("테스트닉").isUsed(true).build();
//
//        testUserStat = new UserStat();
//        testUserStat.setUserNo(1); testUserStat.setIsUsed(true);
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 회원가입 테스트
//
//    @DisplayName("회원가입 성공: 모든 조건 만족 시")
//    @Test
//    void registerUser_Success() {
//        // Given
//        UserDto.SignupRequestDto requestDto = UserDto.SignupRequestDto.builder()
//                .userId("newuser").password("newpass").email("new@example.com")
//                .name("새사용자").phone("010-1111-2222").birth(LocalDate.of(1995, 5, 10))
//                .gender("여성").nickname("새닉네임").build();
//
//        when(userRepository.existsByUserId(anyString())).thenReturn(false);
//        when(userProfileRepository.existsByEmail(anyString())).thenReturn(false);
//        when(userProfileRepository.existsByNickname(anyString())).thenReturn(false);
//        when(passwordEncoder.encode(anyString())).thenReturn("encodedPass");
//        when(userMapper.toUser(any(UserDto.SignupRequestDto.class))).thenReturn(testUser); // mockUser 사용
//        when(userRepository.save(any(User.class))).thenReturn(testUser); // mockUser 반환
//        when(userMapper.toUserProfile(any(UserDto.SignupRequestDto.class))).thenReturn(testUserProfile);
//        when(userProfileRepository.save(any(UserProfile.class))).thenReturn(testUserProfile);
//        when(userStatRepository.save(any(UserStat.class))).thenReturn(testUserStat);
//        when(passwordChangeHistoryRepository.save(any(PasswordChangeHistory.class))).thenReturn(new PasswordChangeHistory());
//
//        // When
//        User result = userAccountService.registerUser(requestDto);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(testUser.getUserId(), result.getUserId());
//        verify(userRepository, times(1)).existsByUserId(requestDto.getUserId());
//        verify(userRepository, times(1)).save(any(User.class));
//        verify(userProfileRepository, times(1)).save(any(UserProfile.class));
//        verify(userStatRepository, times(1)).save(any(UserStat.class));
//        verify(passwordChangeHistoryRepository, times(1)).save(any(PasswordChangeHistory.class));
//    }
//
//    @DisplayName("회원가입 실패: 아이디 중복")
//    @Test
//    void registerUser_Fail_UserIdExists() {
//        // Given
//        UserDto.SignupRequestDto requestDto = UserDto.SignupRequestDto.builder().userId("existingUser").build();
//        when(userRepository.existsByUserId(requestDto.getUserId())).thenReturn(true);
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
//                () -> userAccountService.registerUser(requestDto));
//        assertEquals("이미 존재하는 사용자 ID입니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class)); // 저장 안 됐음을 검증
//    }
//
//    @DisplayName("회원가입 실패: 이메일 중복")
//    @Test
//    void registerUser_Fail_EmailExists() {
//        // Given
//        UserDto.SignupRequestDto requestDto = UserDto.SignupRequestDto.builder().userId("newuser").email("existing@example.com").build();
//        when(userRepository.existsByUserId(requestDto.getUserId())).thenReturn(false);
//        when(userProfileRepository.existsByEmail(requestDto.getEmail())).thenReturn(true);
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
//                () -> userAccountService.registerUser(requestDto));
//        assertEquals("이미 사용 중인 이메일입니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class));
//    }
//
//    @DisplayName("회원가입 실패: 닉네임 중복")
//    @Test
//    void registerUser_Fail_NicknameExists() {
//        // Given
//        UserDto.SignupRequestDto requestDto = UserDto.SignupRequestDto.builder().userId("newuser").email("new@example.com").nickname("existingNick").build();
//        when(userRepository.existsByUserId(requestDto.getUserId())).thenReturn(false);
//        when(userProfileRepository.existsByEmail(requestDto.getEmail())).thenReturn(false);
//        when(userProfileRepository.existsByNickname(requestDto.getNickname())).thenReturn(true);
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
//                () -> userAccountService.registerUser(requestDto));
//        assertEquals("이미 사용 중인 닉네임입니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class));
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 로그인 테스트
//
//    @DisplayName("로그인 성공: 올바른 ID와 비밀번호")
//    @Test
//    void login_Success() {
//        // Given
//        UserDto.LoginRequestDto requestDto = new UserDto.LoginRequestDto();
//        requestDto.setUserId("testuser");
//        requestDto.setPassword("testpass"); // 입력할 비밀번호
//
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(testUser));
//        when(passwordEncoder.matches("testpass", testUser.getPassword())).thenReturn(true); // 입력 비밀번호와 저장된 비밀번호 일치
//
//        // When
//        Optional<User> result = userAccountService.login(requestDto);
//
//        // Then
//        assertTrue(result.isPresent());
//        assertEquals("testuser", result.get().getUserId());
//        verify(userRepository, times(1)).findByUserId("testuser");
//        verify(passwordEncoder, times(1)).matches("testpass", testUser.getPassword());
//    }
//
//    @DisplayName("로그인 실패: 사용자 ID 없음")
//    @Test
//    void login_Fail_UserNotFound() {
//        // Given
//        UserDto.LoginRequestDto requestDto = new UserDto.LoginRequestDto();
//        requestDto.setUserId("nonexistent");
//        requestDto.setPassword("anypass");
//
//        when(userRepository.findByUserId("nonexistent")).thenReturn(Optional.empty()); // 사용자 없음
//
//        // When
//        Optional<User> result = userAccountService.login(requestDto);
//
//        // Then
//        assertFalse(result.isPresent());
//        verify(userRepository, times(1)).findByUserId("nonexistent");
//        verify(passwordEncoder, never()).matches(anyString(), anyString()); // 비밀번호 검증 호출 안 됨
//    }
//
//    @DisplayName("로그인 실패: 비밀번호 불일치")
//    @Test
//    void login_Fail_PasswordMismatch() {
//        // Given
//        UserDto.LoginRequestDto requestDto = new UserDto.LoginRequestDto();
//        requestDto.setUserId("testuser");
//        requestDto.setPassword("wrongpass");
//
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(testUser));
//        when(passwordEncoder.matches("wrongpass", testUser.getPassword())).thenReturn(false); // 비밀번호 불일치
//
//        // When
//        Optional<User> result = userAccountService.login(requestDto);
//
//        // Then
//        assertFalse(result.isPresent());
//        verify(userRepository, times(1)).findByUserId("testuser");
//        verify(passwordEncoder, times(1)).matches("wrongpass", testUser.getPassword());
//    }
//
//    @DisplayName("로그인 실패: 비활성화된 계정")
//    @Test
//    void login_Fail_AccountNotUsed() {
//        // Given
//        User disabledUser = User.builder().userId("disabled").password("encodedPass").isUsed(false).build();
//        UserDto.LoginRequestDto requestDto = new UserDto.LoginRequestDto();
//        requestDto.setUserId("disabled");
//        requestDto.setPassword("encodedPass");
//
//        when(userRepository.findByUserId("disabled")).thenReturn(Optional.of(disabledUser));
//
//        // When
//        Optional<User> result = userAccountService.login(requestDto);
//
//        // Then
//        assertFalse(result.isPresent());
//        verify(userRepository, times(1)).findByUserId("disabled");
//        verify(passwordEncoder, never()).matches(anyString(), anyString()); // isUsed 검사 후 통과 못했으므로 matches 호출 안 됨
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 아이디 찾기 테스트
//
//    @DisplayName("아이디 찾기 성공: 이름과 이메일 일치 시 마스킹된 ID 반환")
//    @Test
//    void readUserIdByNameAndEmail_Success() {
//        // Given
//        UserDto.UserIdFindRequestDto requestDto = new UserDto.UserIdFindRequestDto("test@example.com", "테스트");
//        User foundUser = User.builder().userId("longuseridexample").build(); // 6자 이상 ID
//        when(userRepository.findByNameAndEmail("테스트", "test@example.com")).thenReturn(Optional.of(foundUser));
//
//        // When
//        Optional<UserDto.UserIdFindResponseDto> result = userAccountService.readUserIdByNameAndEmail(requestDto);
//
//        // Then
//        assertTrue(result.isPresent());
//        // longuseridexample -> lo********e (앞2, 뒤1, 중간 별표 8개)
//        assertEquals("lo********e", result.get().getUserId());
//        verify(userRepository, times(1)).findByNameAndEmail("테스트", "test@example.com");
//    }
//
//    @DisplayName("아이디 찾기 실패: 이름 또는 이메일 불일치")
//    @Test
//    void readUserIdByNameAndEmail_Fail_NoMatch() {
//        // Given
//        UserDto.UserIdFindRequestDto requestDto = new UserDto.UserIdFindRequestDto("wrong@example.com", "잘못된이름");
//        when(userRepository.findByNameAndEmail("잘못된이름", "wrong@example.com")).thenReturn(Optional.empty());
//
//        // When
//        Optional<UserDto.UserIdFindResponseDto> result = userAccountService.readUserIdByNameAndEmail(requestDto);
//
//        // Then
//        assertFalse(result.isPresent());
//        verify(userRepository, times(1)).findByNameAndEmail("잘못된이름", "wrong@example.com");
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 비밀번호 변경 요청 테스트 (requestPasswordReset)
//
//    @DisplayName("비밀번호 재설정 요청 성공: 사용자 정보 일치 시")
//    @Test
//    void requestPasswordReset_Success() {
//        // Given
//        UserDto.PasswordResetRequestDto requestDto = new UserDto.PasswordResetRequestDto("testuser", "test@example.com", "newSecurePass");
//        // UserAccountServiceImp에 requestPasswordReset 메서드에 name 파라미터가 없으므로 name을 DTO에 추가하거나,
//        // userMapper.toUser() 호출 시 name 필드를 매핑하는 로직이 필요
//        // 현재 코드에서는 DTO에 name이 없고, findByUserIdAndEmail을 사용하므로 userRepository.findByUserIdAndEmail로 가정
//
//        User userForReset = User.builder().userId("testuser").email("test@example.com").name("테스트").build();
//        when(userRepository.findByUserIdAndEmail("testuser", "test@example.com")).thenReturn(Optional.of(userForReset));
//        // when(tokenProvider.generatePasswordResetToken(anyString())).thenReturn("mockResetToken");
//        // doNothing().when(emailService).sendEmail(anyString(), anyString(), anyString()); // EmailService Mocking 필요
//
//        // When
//        userAccountService.requestPasswordReset(requestDto);
//
//        // Then
//        // verify(tokenProvider, times(1)).generatePasswordResetToken("testuser");
//        // verify(emailService, times(1)).sendEmail(eq("test@example.com"), anyString(), anyString());
//        // TODO: 실제 구현 시 토큰 저장 로직 검증도 추가
//    }
//
//    @DisplayName("비밀번호 재설정 요청 실패: 사용자 정보 불일치")
//    @Test
//    void requestPasswordReset_Fail_UserMismatch() {
//        // Given
//        UserDto.PasswordResetRequestDto requestDto = new UserDto.PasswordResetRequestDto("wronguser", "wrong@example.com", "newPass");
//        when(userRepository.findByUserIdAndEmail(anyString(), anyString())).thenReturn(Optional.empty());
//
//        // When
//        userAccountService.requestPasswordReset(requestDto); // void 메서드이므로 예외가 발생하지 않으면 성공
//
//        // Then
//        // verify(tokenProvider, never()).generatePasswordResetToken(anyString()); // 토큰 생성 호출 안 됨
//        // verify(emailService, never()).sendEmail(anyString(), anyString(), anyString()); // 이메일 전송 호출 안 됨
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 비밀번호 변경 테스트 (changePassword)
//
//    @DisplayName("비밀번호 변경 성공: 현재 비밀번호 일치 시")
//    @Test
//    void changePassword_Success() {
//        // Given
//        UserDto.PasswordChangeRequestDto requestDto = new UserDto.PasswordChangeRequestDto("oldPass", "newPass");
//        User user = testUser; // setUp에서 정의된 사용자
//        user.setPassword(passwordEncoder.encode("oldPass")); // 기존 비밀번호 설정
//        String oldEncodedPass = user.getPassword(); // 변경 전 비밀번호 저장
//
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(user));
//        when(passwordEncoder.matches("oldPass", oldEncodedPass)).thenReturn(true);
//        when(passwordEncoder.encode("newPass")).thenReturn("encodedNewPass");
//        when(userRepository.save(any(User.class))).thenReturn(user); // 저장 시 반환
//
//        // When
//        userAccountService.changePassword("testuser", requestDto);
//
//        // Then
//        // user.setPassword("encodedNewPass") 호출되었는지 확인
//        assertEquals("encodedNewPass", user.getPassword()); // 엔티티의 비밀번호가 업데이트되었는지 확인
//        verify(userRepository, times(1)).findByUserId("testuser");
//        verify(passwordEncoder, times(1)).matches("oldPass", oldEncodedPass);
//        verify(passwordEncoder, times(1)).encode("newPass");
//        verify(userRepository, times(1)).save(user); // save 호출 검증
//
//        // passwordChangeHistoryRepository save 검증
//        verify(passwordChangeHistoryRepository, times(1)).save(any(PasswordChangeHistory.class));
//        // TODO: PasswordChangeHistory 객체의 oldPw가 올바르게 설정되었는지 추가 검증 가능
//    }
//
//    @DisplayName("비밀번호 변경 실패: 사용자 없음")
//    @Test
//    void changePassword_Fail_UserNotFound() {
//        // Given
//        UserDto.PasswordChangeRequestDto requestDto = new UserDto.PasswordChangeRequestDto("oldPass", "newPass");
//        when(userRepository.findByUserId("nonexistent")).thenReturn(Optional.empty());
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
//            userAccountService.changePassword("nonexistent", requestDto);
//        });
//        assertEquals("사용자를 찾을 수 없습니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class)); // 저장 안 됨
//        verify(passwordChangeHistoryRepository, never()).save(any(PasswordChangeHistory.class)); // 이력 저장 안 됨
//    }
//
//    @DisplayName("비밀번호 변경 실패: 현재 비밀번호 불일치")
//    @Test
//    void changePassword_Fail_CurrentPasswordMismatch() {
//        // Given
//        UserDto.PasswordChangeRequestDto requestDto = new UserDto.PasswordChangeRequestDto("wrongOldPass", "newPass");
//        User user = testUser; // setUp에서 정의된 사용자
//        user.setPassword(passwordEncoder.encode("correctOldPass")); // 실제 저장된 비밀번호
//
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(user));
//        when(passwordEncoder.matches("wrongOldPass", user.getPassword())).thenReturn(false); // 비밀번호 불일치
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
//            userAccountService.changePassword("testuser", requestDto);
//        });
//        assertEquals("현재 비밀번호가 일치하지 않습니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class)); // 저장 안 됨
//        verify(passwordChangeHistoryRepository, never()).save(any(PasswordChangeHistory.class)); // 이력 저장 안 됨
//    }
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 프로필 조회 테스트 (getUserAccountProfile)
//
//    @DisplayName("프로필 조회 성공: 사용자 존재 시")
//    @Test
//    void getUserAccountProfile_Success() {
//        // Given
//        // User, UserProfile, UserStat, UserImg가 모두 존재한다고 가정
//        UserImg testUserImg = UserImg.builder().userNo(1).prfImgUrl("http://img.url/profile.jpg").build();
//        UserStat testUserStatWithData = new UserStat();
//        testUserStatWithData.setUserNo(1); testUserStatWithData.setFollowerCount(10); testUserStatWithData.setFollowingCount(5); testUserStatWithData.setPostCount(3); testUserStatWithData.setIsUsed(true);
//
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(testUser));
//        when(userProfileRepository.findById(testUser.getUserNo())).thenReturn(Optional.of(testUserProfile));
//        when(userStatRepository.findById(testUser.getUserNo())).thenReturn(Optional.of(testUserStatWithData));
//        when(userImgRepository.findByUserNo(testUser.getUserNo())).thenReturn(Optional.of(testUserImg));
//
//        // 매퍼가 User, UserProfile을 받아 DTO의 기본 필드를 매핑한다고 가정 (UserMapper 수정 권고)
//        UserDto.UserProfileResponseDto expectedDto = UserDto.UserProfileResponseDto.builder()
//                .userId(testUser.getUserId()).email(testUser.getEmail()).name(testUser.getName())
//                .nickname(testUserProfile.getNickname()).build(); // 기본 매핑 필드
//        when(userMapper.toUserProfileResponseDto(any(User.class))).thenReturn(expectedDto);
//
//
//        // When
//        Optional<UserDto.UserProfileResponseDto> result = userAccountService.getUserAccountProfile("testuser");
//
//        // Then
//        assertTrue(result.isPresent());
//        UserDto.UserProfileResponseDto responseDto = result.get();
//        assertEquals("testuser", responseDto.getUserId());
//        assertEquals("http://img.url/profile.jpg", responseDto.getProfileImageUrl()); // UserImg 정보 확인
//        assertEquals(10, responseDto.getFollowerCount()); // UserStat 정보 확인
//        assertEquals(5, responseDto.getFollowingCount());
//        assertEquals(3, responseDto.getPostCount());
//
//        verify(userRepository, times(1)).findByUserId("testuser");
//        verify(userProfileRepository, times(1)).findById(testUser.getUserNo());
//        verify(userStatRepository, times(1)).findById(testUser.getUserNo());
//        verify(userImgRepository, times(1)).findByUserNo(testUser.getUserNo());
//        verify(userMapper, times(1)).toUserProfileResponseDto(any(User.class));
//    }
//
//    @DisplayName("프로필 조회 실패: 사용자 없음")
//    @Test
//    void getUserAccountProfile_Fail_UserNotFound() {
//        // Given
//        when(userRepository.findByUserId("nonexistent")).thenReturn(Optional.empty());
//
//        // When
//        Optional<UserDto.UserProfileResponseDto> result = userAccountService.getUserAccountProfile("nonexistent");
//
//        // Then
//        assertFalse(result.isPresent());
//        verify(userRepository, times(1)).findByUserId("nonexistent");
//        // 다른 레포지토리나 매퍼는 호출되지 않음을 검증
//        verify(userProfileRepository, never()).findById(anyInt());
//        verify(userStatRepository, never()).findById(anyInt());
//        verify(userImgRepository, never()).findByUserNo(anyInt());
//        verify(userMapper, never()).toUserProfileResponseDto(any(User.class));
//    }
//
//
//    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 회원 탈퇴 테스트 (withdrawAccount)
//
//    @DisplayName("회원 탈퇴 성공: 올바른 비밀번호 및 활성화된 계정")
//    @Test
//    void withdrawAccount_Success() {
//        // Given
//        User user = testUser; // setUp에서 정의된 사용자
//        UserProfile userProfile = testUserProfile;
//        UserStat userStat = testUserStat;
//        UserImg userImg = UserImg.builder().userNo(1).build(); // 더미 UserImg
//
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(user));
//        when(passwordEncoder.matches("correctPass", user.getPassword())).thenReturn(true); // 비밀번호 일치
//        when(userProfileRepository.findById(user.getUserNo())).thenReturn(Optional.of(userProfile));
//        when(userStatRepository.findById(user.getUserNo())).thenReturn(Optional.of(userStat));
//        when(userImgRepository.findByUserNo(user.getUserNo())).thenReturn(Optional.of(userImg));
//
//        // When
//        userAccountService.withdrawAccount("testuser", "correctPass");
//
//        // Then
//        assertFalse(user.getIsUsed()); // User 엔티티의 isUsed가 false로 변경되었는지
//        assertNotNull(user.getDropoutAt()); // 탈퇴 시간이 설정되었는지
//        assertEquals("유저에 의한 탈퇴", user.getMemo()); // 메모가 설정되었는지
//
//        assertFalse(userProfile.getIsUsed()); // UserProfile isUsed 변경 검증
//        assertFalse(userStat.getIsUsed());    // UserStat isUsed 변경 검증
//        assertFalse(userImg.getIsUsed());     // UserImg isUsed 변경 검증
//
//        verify(userRepository, times(1)).findByUserId("testuser");
//        verify(passwordEncoder, times(1)).matches("correctPass", user.getPassword());
//        verify(userRepository, times(1)).save(user); // User 엔티티 저장 검증
//        verify(userProfileRepository, times(1)).save(userProfile);
//        verify(userStatRepository, times(1)).save(userStat);
//        verify(userImgRepository, times(1)).save(userImg);
//    }
//
//    @DisplayName("회원 탈퇴 실패: 사용자 없음")
//    @Test
//    void withdrawAccount_Fail_UserNotFound() {
//        // Given
//        when(userRepository.findByUserId("nonexistent")).thenReturn(Optional.empty());
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
//            userAccountService.withdrawAccount("nonexistent", "anyPass");
//        });
//        assertEquals("사용자를 찾을 수 없습니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class)); // 저장 안 됨
//    }
//
//    @DisplayName("회원 탈퇴 실패: 비밀번호 불일치")
//    @Test
//    void withdrawAccount_Fail_PasswordMismatch() {
//        // Given
//        User user = testUser;
//        when(userRepository.findByUserId("testuser")).thenReturn(Optional.of(user));
//        when(passwordEncoder.matches("wrongPass", user.getPassword())).thenReturn(false);
//
//        // When & Then
//        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
//            userAccountService.withdrawAccount("testuser", "wrongPass");
//        });
//        assertEquals("비밀번호가 일치하지 않습니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class));
//    }
//
//    @DisplayName("회원 탈퇴 실패: 이미 탈퇴된 계정")
//    @Test
//    void withdrawAccount_Fail_AlreadyWithdrawn() {
//        // Given
//        User withdrawnUser = User.builder().userId("withdrawn").password("encodedPass").isUsed(false).build();
//        when(userRepository.findByUserId("withdrawn")).thenReturn(Optional.of(withdrawnUser));
//        when(passwordEncoder.matches("encodedPass", withdrawnUser.getPassword())).thenReturn(true); // 비밀번호는 일치
//
//        // When & Then
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
//            userAccountService.withdrawAccount("withdrawn", "encodedPass");
//        });
//        assertEquals("이미 탈퇴 처리된 계정입니다.", e.getMessage());
//        verify(userRepository, never()).save(any(User.class));
//    }
//}