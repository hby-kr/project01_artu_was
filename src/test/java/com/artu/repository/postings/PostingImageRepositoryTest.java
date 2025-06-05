package com.artu.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostingImageRepositoryTest {
    @Autowired
    PostingImageRepository postingImageRepository;

    @Test
    void findByPostId() {
        System.out.println(postingImageRepository.findByPost_PostId(1));
    }
}