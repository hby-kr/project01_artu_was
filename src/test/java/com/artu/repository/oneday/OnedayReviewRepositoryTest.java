package com.artu.repository.oneday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OnedayReviewRepositoryTest {
    @Autowired
    private OnedayReviewRepository onedayReviewRepository;

    @Test
    void findAll() {
        System.out.println(onedayReviewRepository.findAll());
    }

    @Test
    void findByOnedayClass_OnedayId() {
        System.out.println(onedayReviewRepository.findByOnedayClass_OnedayId(1));
    }

    @Test
    void findByUser_UserNo() {
        System.out.println(onedayReviewRepository.findByUser_UserNo(11));
    }

    @Test
    void findByOnedayClass_Category_CtgrId() {
        System.out.println(onedayReviewRepository.findByOnedayClass_Category_CtgrId(1));
    }
}