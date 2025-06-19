package com.artu.service.users;


import com.artu.dto.UserDto;
import com.artu.entity.users.User;

import java.util.Optional;

public interface UserAccountService {

    /*
    회원 서비스 규칙 정하기
    회원정보의 name, nickname, email, user_id가 있음.
    name은 실명
    email는 외부 이메일, OAuth에서도 활용. 변경불가.
    user_id는 중복불가, 변경불가.
    nickname는 변경가능

    로그인은 user_id와 비번을 물어봐서 요청 받음
    따라서 아이디 찾기 기능구현 해야함.
    아이디와 비번 찾을 때, 이메일의 일부를 보여주고, 일부를 요청자에게 확인해야하며,
    가능하면 이메일을 통해 본인 인증 후 처리함.
    */

    // 회원가입
    // 새로운 사용자 계정을 생성하고 프로필 정보를 저장합니다.
    User registerUser(UserDto.SignupRequestDto requestDto);
    // 계정 생성 시 특정 사용자 ID의 존재 여부를 확인합니다.
    boolean checkUserIdExists(String userId);
    // 계정 생성 시 특정 이메일의 존재 여부를 확인합니다.
    boolean checkEmailExists(String email);

    // 로그인
    // 사용자 로그인 요청을 처리합니다.
    Optional<User> login(UserDto.LoginRequestDto requestDto);


    // 아이디,비번 찾기
    // 이메일을 통해 사용자 ID를 찾습니다.
    Optional<UserDto.UserIdFindResponseDto> readUserIdByEmail(UserDto.UserIdFindRequestDto requestDto);
    // (비번 모르는 사람이 본인 인증 후) 비밀번호 재설정을 요청합니다.
    void requestPasswordReset(UserDto.PasswordResetRequestDto requestDto);


    // 마이페이지 내에서 사용자의 비밀번호를 변경합니다.
    void changePassword(String userId, UserDto.PasswordChangeRequestDto requestDto);

    // 회원 탈퇴
    // 사용자 계정을 탈퇴(비활성화 또는 논리적 삭제) 처리합니다.
    void withdrawAccount(String userId, String password);

}