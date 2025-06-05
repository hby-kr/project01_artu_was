package com.artu.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostingRepositoryTest {
    @Autowired
    PostingRepository postingRepository;

    @Test
    void findByUserNo() {
        System.out.println(postingRepository.findByUser_UserNo(1));
    }

    @Test
    void findByPostId() {
        System.out.println(postingRepository.findByPostId(1));
    }

    @Test
    void countPostingsByUser_UserNo() {
        System.out.println(postingRepository.countPostingsByUser_UserNo(1));
    }
}