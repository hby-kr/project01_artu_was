package com.artu.dto.posting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

public class PostingImageDto {
    // 이미지 등록
    @Getter
    @Setter
    @ToString
    public static class PostingImageRequestDto {
        private Integer postId;
        private Integer imgOrder;
        private String imgUrl;
    }

    // 이미지 조회
    @Getter
    @Setter
    @ToString
    public static class PostingImageResponseDto {
        private Integer imgId;
        private Integer postId;
        private Integer imgOrder;
        private String imgUrl;
        private Instant createdAt;
    }

    // 이미지 수정
    @Getter
    @Setter
    @ToString
    public static class PostingImageUpdateDto {
        private Integer imgId;
        private Integer postId;
        private Integer imgOrder;
        private String imgUrl;
        private Instant createdAt;
    }
}
