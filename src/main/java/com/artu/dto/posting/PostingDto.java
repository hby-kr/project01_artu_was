package com.artu.dto.posting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

public class PostingDto {
    // 게시물 등록
    @Getter
    @Setter
    @ToString
    public static class PostingRequestDto {
        private Integer userNo;
        private String contents;
        private String visibilityType;
    }

    // 게시물 조회
    @Getter
    @Setter
    @ToString
    public static class PostingResponseDto {
        private Integer postId;
        private Integer userNo;
        private String contents;
        private Integer likeCount;
        private Instant createdAt;
        private Instant editedAt;
        private Boolean isReported;
    }

    // 게시물 수정
    @Getter
    @Setter
    @ToString
    public static class PostingUpdateDto {
        private Integer postId;
        private Integer userNo;
        private String contents;
        private String visibilityType;
        private Instant editedAt;
    }





}
