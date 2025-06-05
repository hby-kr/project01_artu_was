package com.artu.repository.users;

import com.artu.entity.users.account.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSettingRepository extends JpaRepository<UserSetting, Integer> {
    // 유저별 세팅
    Optional<UserSetting> findOneByUser_UserNo(Integer userNo);
}
