package com.artu.repository.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserImageRepositoryTest {
    @Autowired
    UserImageRepository userImageRepository;

    @Test
    void findUserImgByUser_UserNo() {
        System.out.println(userImageRepository.findUserImgByUser_UserNo(1));
    }
}