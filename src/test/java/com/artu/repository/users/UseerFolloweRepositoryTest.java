package com.artu.repository.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UseerFolloweRepositoryTest {
    @Autowired
    UserFollowRepository useerFolloweRepository;

    @Test
    void findByFollowerId_UserNoAndFolloweeId_UserNo() {
        System.out.println(useerFolloweRepository.findByFollowerId_UserNoAndFolloweeId_UserNo(1, 1));
    }

    @Test
    void countByFollowerId_UserNo() {
        System.out.println(useerFolloweRepository.countByFollowerId_UserNo(1));
    }

    @Test
    void countByFolloweeId_UserNo() {
        System.out.println(useerFolloweRepository.countByFolloweeId_UserNo(1));
    }
}