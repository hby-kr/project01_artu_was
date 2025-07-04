package com.artu.service.postings;

import com.artu.dto.posting.PostingCommentDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PostingCommentService {
    // 댓글 등록
    PostingCommentDto.PostingCommentResponseDto save(PostingCommentDto.PostingCommentRequestDto postingCommentRequestDto);

    // 댓글 삭제
    PostingCommentDto.PostingCommentResponseDto delete(Integer commentId);

    // 게시물 해당 댓글 조회
    Set<PostingCommentDto.PostingCommentResponseDto> findByPost_PostId(Integer postId);

    // 댓글 단건 조회
    Optional<PostingCommentDto.PostingCommentResponseDto> findByCommentId(Integer commentId);

    // 사용자 댓글 조회
    Set<PostingCommentDto.PostingCommentResponseDto> findByUserNo(Integer userNo);

}
