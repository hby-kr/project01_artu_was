package com.artu.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostingLikeRepositoryTest {
    @Autowired
    PostingLikeRepository postingLikeRepository;

    @Test
    void findByUser_UserNo() {
        System.out.println(postingLikeRepository.findByUser_UserNo(1));
    }

    @Test
    void countPostingLikeByPost_PostId() {
        System.out.println(postingLikeRepository.countPostingLikeByPost_PostId(1));
    }
}