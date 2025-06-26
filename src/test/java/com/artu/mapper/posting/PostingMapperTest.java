package com.artu.mapper.posting;

import com.artu.dto.posting.PostingDto;
import com.artu.entity.postings.Posting;
import com.artu.entity.users.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostingMapperTest {
    @Autowired
    PostingMapper postingMapper;

    @Test
    void toEntity() {
        PostingDto.PostingRequestDto dto = new PostingDto.PostingRequestDto();
        dto.setUserNo(1);
        dto.setContents("테스트 내용입니다.");
        dto.setVisibilityType("all");
        Posting entity = postingMapper.toEntity(dto);
        System.out.println(entity);
    }

    @Test
    void testToEntity() {
        PostingDto.PostingUpdateDto updateDto = new PostingDto.PostingUpdateDto();
        updateDto.setUserNo(1);
        updateDto.setContents("내용내용..");
        updateDto.setVisibilityType("friends");
        Posting entity = postingMapper.toEntity(updateDto);
        System.out.println(entity);
    }

    @Test
    void toRequestDto() {
        User user = new User();
        user.setUserNo(1);
        Posting posting = new Posting();
        posting.setUser(user);
        posting.setContents("내용내용..");
        posting.setVisibilityType("friends");
        PostingDto.PostingRequestDto dto = postingMapper.toRequestDto(posting);
        System.out.println(dto);
    }

    @Test
    void toResponseDto() {
        User user = new User();
        user.setUserNo(1);
        Posting posting = new Posting();
        posting.setPostId(100);
        posting.setUser(user);
        posting.setContents("내용입니다");
        posting.setLikeCount(10);
        posting.setCreatedAt(java.time.Instant.now());
        posting.setEditedAt(java.time.Instant.now());
        posting.setIsReported(false);
        PostingDto.PostingResponseDto dto = postingMapper.toResponseDto(posting);
        System.out.println(dto);
    }

    @Test
    void toUpdateDto() {
        User user = new User();
        user.setUserNo(1);
        Posting posting = new Posting();
        posting.setPostId(100);
        posting.setUser(user);
        posting.setContents("내용내용..");
        posting.setVisibilityType("friends");
        posting.setLikeCount(10);
        posting.setCreatedAt(java.time.Instant.now());
        posting.setEditedAt(java.time.Instant.now());
        posting.setIsReported(false);
        PostingDto.PostingResponseDto dto = postingMapper.toResponseDto(posting);
        System.out.println(dto);
    }
}