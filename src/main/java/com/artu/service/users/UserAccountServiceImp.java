package com.artu.service.users;

import com.artu.dto.UserDto;
import com.artu.entity.users.User;
import com.artu.entity.users.account.PasswordChangeHistory;
import com.artu.entity.users.activity.UserImg;
import com.artu.entity.users.activity.UserProfile;
import com.artu.entity.users.activity.UserStat;
import com.artu.mapper.UserMapper;
import com.artu.repository.users.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder; // 비밀번호 암호화를 위해 필요
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor // final 필드를 사용하는 생성자
public class UserAccountServiceImp implements UserAccountService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화/복호화에 사용

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserStatRepository userStatRepository;
    private final PasswordChangeHistoryRepository passwordChangeHistoryRepository;
    private final UserImgRepository userImgRepository;


/*
컨트롤러와 서비스 계층의 역할 분리 (회원가입 예시)!!!

1. 컨트롤러에서 할 일:

    요청 수신 및 DTO 매핑:
        클라이언트로부터 HTTP POST 요청(폼 데이터)을 받아서 SignupRequestDto 객체로 매핑합니다.
        (Spring의 @RequestBody나 @ModelAttribute를 통해 자동으로 처리됩니다.)

    1차 유효성 검증 (DTO 형식 검증):
        DTO에 @NotBlank, @Email, @Size 등 Jakarta Validation (Bean Validation) 어노테이션을 사용하여 데이터의 형식이 올바른지,
        필드가 비어있지 않은지 등의 기본적인 유효성 검사를 수행합니다.
        이는 HTTP 요청 자체의 유효성(예: 필드 누락, 잘못된 형식)을 확인하여 불필요한 서비스 계층 호출을 막습니다.
        예시: userId가 비어있는 경우, @NotBlank가 이를 잡아내어 컨트롤러 레벨에서 바로 오류 응답을 보낼 수 있습니다.

    서비스 계층 호출:
        유효성 검사를 통과한 SignupRequestDto 객체를 UserAccountService의 registerUser 메서드에 전달합니다.

    응답 반환:
        서비스 계층으로부터 받은 결과를 적절한 HTTP 응답(예: 201 Created와 함께 생성된 사용자 정보 DTO)으로 변환하여 클라이언트에게 전송합니다.
        서비스 계층에서 발생한 예외를 적절히 처리하여 HTTP 상태 코드(예: 400 Bad Request, 409 Conflict)와 오류 메시지를 반환합니다.

컨트롤러에서 하지 않을 일:
    비즈니스 로직(예: 비밀번호 암호화, 데이터베이스 저장).
    데이터 중복 확인(이메일, 아이디 중복 확인 등)과 같은 도메인 특화된 유효성 검사.


2. 서비스에서 할 일:

    2차 유효성 검증 (도메인/비즈니스 유효성 검증):
        userId 또는 email의 중복 여부 확인과 같이 데이터베이스에 접근하여 확인해야 하는 비즈니스 규칙 관련 유효성 검사를 수행합니다.
        닉네임 변경 가능 규칙에 따라 회원가입 시 닉네임 중복을 허용할지 등의 비즈니스 로직을 여기서 결정하고 검증합니다.
    DTO -> 엔티티 매핑:
        MapStruct를 사용하여 SignupRequestDto를 User 엔티티로 변환합니다.
        이때 DTO에 없는 필드(예: role, createdAt, isUsed)는 서비스 로직 내에서 기본값을 설정하거나 도메인 규칙에 따라 값을 할당합니다.

    비밀번호 암호화:
        받은 비밀번호를 PasswordEncoder를 사용하여 안전하게 암호화합니다.

    데이터베이스 저장:
        맵핑 및 암호화가 완료된 User 엔티티를 UserRepository를 통해 데이터베이스에 저장합니다.
        필요하다면 UserProfileRepository, UserStatsRepository 등 관련 테이블에 초기 데이터를 저장하는 로직도 여기서 처리합니다.

    트랜잭션 관리:
        @Transactional 어노테이션을 사용하여 여러 데이터베이스 작업(예: User 저장, UserProfile 저장)이 하나의 원자적인 단위로 처리되도록 보장합니다.
    예외 처리 및 비즈니스 결과 반환:
        비즈니스 규칙 위반(예: 중복 아이디) 시 특정 예외를 발생시키고, 성공 시에는 필요한 결과(예: 생성된 User 엔티티 또는 DTO)를 컨트롤러에 반환합니다.

서비스에서 하지 않을 일:
    HTTP 요청/응답 직접 처리.
*/


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  회원가입
    @Override
    @Transactional // 메서드 실행 중 DB 작업에 트랜잭션 적용
    public User registerUser(UserDto.SignupRequestDto signupRequestDto) {
        // 1. 아이디,이메일,닉네임 중복 확인
        if (userRepository.existsByUserId(signupRequestDto.getUserId())) {
            throw new IllegalArgumentException("이미 존재하는 사용자 ID입니다.");
        }
        if (userProfileRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }
        if (userProfileRepository.existsByNickname(signupRequestDto.getNickname())) {
            throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
        }

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());


        // 3. User 관련 엔티티 생성 및 필드 설정 (MapStruct 활용).
        // 세 번 작업해야함 users, UserProfile. UserStat 엔터티.
        // 왜냐 같은 userNo로 데이터가 형성되게 DB를 설계했으므로, 동시에 생성되어야 이후 매칭이 됨.
        // 즉 회원생성과 동시에 세 데이터가 생기는 것.

        // 3-1. User 엔티티
        User user = userMapper.toUser(signupRequestDto); // DTO의 userId를 User 엔터티로 매핑
        // MapStruct 매핑 후, 암호화된 비밀번호와 기타 기본값 설정
        user.setPassword(encodedPassword);
        user.setRole(User.UserRole.USER);
        user.setIsUsed(true);
        user.setCreatedAt(LocalDateTime.now());
        User savedUser = userRepository.save(user); // DB에 User 엔티티 저장
        // save() 메서드는 "저장된 엔티티 객체"를 반환. 아래에서 써야하므로.

        // 3-2. UserProfile 엔티티
        UserProfile userProfile = userMapper.toUserProfile(signupRequestDto);
        // MapStruct 매핑 후, 회원번호와 기타 기본값 설정
        userProfile.setUserNo(savedUser.getUserNo()); // User의 user_no가 UserProfile의 외래키이자 기본키인 1:1관계임
        userProfile.setIsUsed(true);
        userProfileRepository.save(userProfile); // DB에 UserProfile 엔티티 저장

        // 3-3 UserStat 엔터티
        UserStat userStat = new UserStat();
        userStat.setUserNo(savedUser.getUserNo());
        userStat.setIsUsed(true);
        userStatRepository.save(userStat);

        // 4. PasswordChangeHistory 비밀번호 변경이력 최초생성하기
        PasswordChangeHistory passwordChangeHistory = new PasswordChangeHistory();
        passwordChangeHistory.setUserNo(savedUser.getUserNo());
        passwordChangeHistory.setOldPw(savedUser.getPassword());
        passwordChangeHistory.setChangedAt(Instant.now());
        passwordChangeHistory.setIsUsed(true);
        passwordChangeHistoryRepository.save(passwordChangeHistory);

        return savedUser;  // ?? User 엔티티 반환할 이유가 있나?????
    }

    // 계정 생성 시 특정 사용자 ID의 존재 여부를 확인
    @Override
    public boolean checkUserIdExists(String userId) {
        return userRepository.existsByUserId(userId);
    }

    // 계정 생성 시 특정 이메일의 존재 여부를 확인
    @Override
    public boolean checkEmailExists(String email) {
        return userProfileRepository.existsByEmail(email);
    }


    // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ로그인
    @Override
    @Transactional(readOnly = true) // 읽기 전용 트랜잭션으로, JPA(Hibernate)에서 더티 체킹(Dirty Checking)을 생략하여 성능 최적화
    public Optional<User> login(UserDto.LoginRequestDto requestDto) {

        // 1. 사용자 ID로 사용자 조회
        Optional<User> optionalUser = userRepository.findByUserId(requestDto.getUserId());

        if (optionalUser.isPresent() && optionalUser.get().getIsUsed()) {
            User user = optionalUser.get();
            // 2. 비밀번호 일치 여부 확인
            if (passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
                // matches(입력한 비밀번호 , 저장된 암호화된 비밀번호)

                // 3. 로그인 성공 시, 로그인 로그 등 추가 처리 가능
                // TODO: userLoginLogService.createLog(user.getUserNo(), request.getIpAddress(), request.getUserAgent());
                return Optional.of(user); // 모두 성공시 user 객체 반환
            }
        }
        // 사용자 ID가 없거나 비밀번호가 일치하지 않으면 빈 Optional 반환
        return Optional.empty();
    }


    /* 아이디와 비번 찾을 때,
    1) 이메일의 일부를 보여주고 일부를 요청자에게 확인해야하며,
    2) 이름과 이메일이 모두 일치하면, 아이디의 일부를 보여준다.
    3) 그래도 모르겠는 경우, 그 이메일로 메일을 보내서 아이디를 알려주거나
    3-1) 비밀번호를 재설정 할 수 있는 url을 보내줄 예정.  */
    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto.UserIdFindResponseDto> readUserIdByNameAndEmail(UserDto.UserIdFindRequestDto requestDto) {
        // 1. 이름과 이메일이 모두 일치하는 사용자 조회
        Optional<User> optionalUser = userProfileRepository.findByNameAndEmail(requestDto.getName(), requestDto.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String fullUserId = user.getUserId();

            // 2. 사용자 ID는 항상 6자 이상이므로, 별표 개수를 계산하여 마스킹
            String maskedUserId = fullUserId.substring(0, 2) + // 앞 2자리 추출
                    "*".repeat(fullUserId.length() - 3) + // 중간 (총 길이 - 앞 2자 - 뒤 1자)만큼 별표
                    fullUserId.substring(fullUserId.length() - 1); // 뒤 1자리 추출
            // 마스킹된 사용자 ID를 응답 DTO에 담아 반환
            return Optional.of(new UserDto.UserIdFindResponseDto(maskedUserId));
        }
        // 3. 이름과 이메일이 일치하는 계정을 찾을 수 없는 경우, 빈 Optional 반환
        // 보안을 위해 특정 오류 메시지(예: 계정 없음)를 주지 않습니다.
        return Optional.empty();
    }


    // (비번 모르는 사람이 본인 인증 후) 비밀번호 재설정을 요청합니다.
    @Override
    @Transactional // 비번 변경이기 때문에 트랜잭션.
    public void requestPasswordReset(UserDto.PasswordResetRequestDto requestDto) {
    }


    // 마이페이지 내에서 사용자의 비밀번호를 변경합니다. (로그인 상태)
    @Override
    @Transactional
    public void changePassword(String userId, UserDto.PasswordChangeRequestDto requestDto) {
        // 1. 사용자 ID로 사용자 조회
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")); // Optional.orElseThrow 사용


        // 2. 현재 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(requestDto.getCurrentPassword(), user.getPassword())) {
            throw new IllegalArgumentException("현재 비밀번호가 일치하지 않습니다.");
        }

        // 3. 새로운 비밀번호 암호화 및 업데이트
        String newEncodedPassword = passwordEncoder.encode(requestDto.getNewPassword());
        user.setPassword(newEncodedPassword); // User 엔티티에 비밀번호 업데이트 메서드 추가
        userRepository.save(user); // 변경된 엔티티 저장

        // 4. password_change_histories 테이블에 기록하는 로직 추가
        PasswordChangeHistory passwordChangeHistory = new PasswordChangeHistory();
        passwordChangeHistory.setUserNo(user.getUserNo());
        passwordChangeHistory.setOldPw(user.getPassword());
        passwordChangeHistory.setChangedAt(Instant.now());
        passwordChangeHistory.setIsUsed(true);
        passwordChangeHistoryRepository.save(passwordChangeHistory);
    }


    // 특정 사용자 ID로 본인의 계정 상세 프로필 정보 모두를 조회합니다.
    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto.UserProfileResponseDto> getUserAccountProfile(String userId) {

        // 1. 사용자 ID로 사용자 엔티티 조회
        User user = userRepository.findByUserId(userId)
                .orElse(null); // Optional.orElse(null) 또는 Optional.empty() 반환 시 처리
        if (user == null) {
            return Optional.empty();
        }

        // 2. 조회된 User 엔티티와 관련 정보(user_stats, user_img)를 UserProfileResponseDto로 변환
        int userNo = user.getUserNo();
        Optional<UserProfile> userProfile = userProfileRepository.findById(userNo);
        Optional<UserImg> userImg = userImgRepository.findByUserNo(userNo);
        UserDto.UserProfileResponseDto userProfileResponseDto = userMapper.toUserProfileResponseDto(user, userProfile.get());
        userProfileResponseDto.setProfileImageUrl(userImg.get().getPrfImgUrl());
        // TODO: 서비스상 user_stats에서 팔로잉/팔로워수 필요하면 불러와서 여기서 set하면 됨

        return Optional.of(userProfileResponseDto);
    }

    // 회원 탈퇴
    @Override
    @Transactional
    public void withdrawAccount(String userId, String password) {
        // 1. 사용자 ID로 사용자 조회
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        // 2. 비밀번호 일치 여부 확인
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 3. 계정 논리삭제 (is_used = false)
        if (!user.getIsUsed()) { // 이미 탈퇴된 계정인지 확인 (isUsed가 false인 경우)
            throw new IllegalStateException("이미 탈퇴 처리된 계정입니다.");
        }
        // 사용자 엔티티 상태 변경
        user.setIsUsed(false);
        user.setDropoutAt(LocalDateTime.now()); // Instant 대신 LocalDateTime 사용 권장
        user.setMemo("유저에 의한 탈퇴"); // 상수로 관리하는 것이 좋음: UserConstants.USER_WITHDRAW_MEMO

        // 관련된 다른 엔티티들의 상태 변경 (Optional 처리 강화)
        userProfileRepository.findById(user.getUserNo()).ifPresent(profile -> {
            profile.setIsUsed(false);
            userProfileRepository.save(profile);
        });

        userStatRepository.findById(user.getUserNo()).ifPresent(stats -> {
            stats.setIsUsed(false);
            userStatRepository.save(stats);
        });

        userImgRepository.findByUserNo(user.getUserNo()).ifPresent(img -> {
            img.setIsUsed(false);
            userImgRepository.save(img);
        });

        userRepository.save(user); // User 엔티티 변경사항 저장

    }
}