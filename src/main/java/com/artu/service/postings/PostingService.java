package com.artu.service.postings;

import com.artu.dto.posting.PostingDto;
import com.artu.dto.posting.PostingImageDto;
import com.artu.entity.postings.PostingImage;

import java.util.List;

public interface PostingService {
    // posting 등록
    PostingDto.PostingResponseDto save(PostingDto.PostingRequestDto requestDto);

    // posting 삭제
    PostingDto.PostingResponseDto delete(Integer postId);

    // 사용자 게시물 조회
    List<PostingDto.PostingResponseDto> findByUser_UserNo(Integer userNo);

    // 게시물 단건 조회
    PostingDto.PostingResponseDto findByPostId(Integer postId);

    // 게시물 이미지 조회
     List<PostingImageDto.PostingImageResponseDto> findByPost_PostId(Integer postId);
}
