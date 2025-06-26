package com.artu.repository.users;

import com.artu.entity.users.activity.UserInquire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserInquireRepositoryTest {
    @Autowired
    UserInquireRepository userInquireRepository;

    @Test
    void findByUser_UserNo() {
        System.out.println(userInquireRepository.findByUser_UserNo(1));
    }

    @Test
    void findOneByUser_UserNo() {
        System.out.println(userInquireRepository.findOneByUser_UserNo(1));
    }

    @Test
    void findByInquireCategory() {
        System.out.println(userInquireRepository.findByInquireCategory(UserInquire.InquireCategory.account));
    }
}