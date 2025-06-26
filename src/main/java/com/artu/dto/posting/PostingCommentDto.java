package com.artu.dto.posting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

public class PostingCommentDto {
    // 댓글 등록
    @Getter
    @Setter
    @ToString
    public static class PostingCommentRequestDto {
        private String contents;
        private Integer postId;
        private Integer userNo;
        private Integer parentCommentId;
    }

    // 댓글 조회
    @Getter
    @Setter
    @ToString
    public static class PostingCommentResponseDto {
        private Integer commentId;
        private String contents;
        private Integer postId;
        private Integer userNo;
        private String userId;
        private Instant createdAt;
        private Integer parentCommentId;
    }

    // 댓글 수정
    @Getter
    @Setter
    @ToString
    public static class PostingCommentUpdateDto {
        private Integer commentId;
        private String contents;
        private Integer postId;
        private Integer userNo;
        private String userId;
        private Integer parentCommentId;
        private Instant createdAt;
    }
}
