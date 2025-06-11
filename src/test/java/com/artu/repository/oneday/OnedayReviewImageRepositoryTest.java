package com.artu.repository.oneday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OnedayReviewImageRepositoryTest {
    @Autowired
    private OnedayReviewImageRepository onedayReviewImageRepository;

    @Test
    void findAll() {
        System.out.println(onedayReviewImageRepository.findAll());
    }

    @Test
    void findByOnedayReview_reviewId() {
        System.out.println(onedayReviewImageRepository.findByOnedayReview_reviewId(1));
    }
}