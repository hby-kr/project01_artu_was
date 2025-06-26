package com.artu.mapper.posting;

import com.artu.dto.posting.PostingLikeDto;
import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingLike;
import com.artu.entity.postings.PostingLikeId;
import com.artu.entity.users.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostingLikeMapperTest {
    @Autowired
    PostingLikeMapper postingLikeMapper;

    @Test
    void toEntity() {
        PostingLikeDto dto = new PostingLikeDto();
        dto.setUserNo(1);
        dto.setPostId(300);
        PostingLike entity = postingLikeMapper.toEntity(dto);
        assertNotNull(entity);
        assertNotNull(entity.getPostingLikeId());
        assertEquals(1, entity.getPostingLikeId().getUserNo());
        assertEquals(300, entity.getPostingLikeId().getPostId());
        assertNotNull(entity.getUser());
        assertEquals(1, entity.getUser().getUserNo());
        assertNotNull(entity.getPost());
        assertEquals(300, entity.getPost().getPostId());
        assertTrue(entity.getIsUsed());
        System.out.println(dto);
    }

    @Test
    void toDto() {
        User user = new User();
        user.setUserNo(1);
        Posting posting = new Posting();
        posting.setPostId(300);
        PostingLike postingLike = new PostingLike();
        postingLike.setUser(user);
        postingLike.setPost(posting);
        postingLike.setLikedAt(java.time.Instant.now());
        PostingLikeId id = new PostingLikeId(1, 300);
        postingLike.setPostingLikeId(id);
        PostingLikeDto dto = postingLikeMapper.toDto(postingLike);
        assertNotNull(dto);
        assertEquals(1, dto.getUserNo());
        assertEquals(300, dto.getPostId());
        System.out.println(dto);
    }
}