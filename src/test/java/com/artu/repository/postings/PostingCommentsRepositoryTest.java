package com.artu.repository.postings;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostingCommentsRepositoryTest {
    @Autowired
    private PostingCommentsRepository postingCommentsRepository;

    @Test
    void findByPost_PostId() {
        postingCommentsRepository.findByPost_PostId(1);
    }

    @Test
    void findByUser_UserNo() {
        postingCommentsRepository.findByUser_UserNo(1);
    }
}