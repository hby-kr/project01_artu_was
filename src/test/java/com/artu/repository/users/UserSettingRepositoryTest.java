package com.artu.repository.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserSettingRepositoryTest {
    @Autowired
    UserSettingRepository userSettingRepository;

    @Test
    void findOneByUser_UserNo() {
        System.out.println(userSettingRepository.findOneByUser_UserNo(1));
    }
}