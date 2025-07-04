package com.artu.dto.oneday;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

public class OnedayReviewDto {
    // 원데이클래스 리뷰 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayReviewRequestDto {
        private Integer userNo;
        private Integer onedayId;
        private String contents;
        private Integer rate;
    }

    // 원데이클래스 리뷰 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayReviewResponseDto {
        private Integer reviewId;
        private Integer userNo;
        private String userId;
        private String nickname;
        private Integer onedayId;
        private String contents;
        private Integer rate;
        private Instant createdAt;
    }

    // 원데이클래스 리뷰 수정
    @Getter
    @Setter
    @ToString
    public static class OnedayReviewUpdateDto {
        private Integer reviewId;
        private Integer userNo;
        private String userId;
        private String nickname;
        private Integer onedayId;
        private String contents;
        private Integer rate;
    }


    // 원데이클래스 리뷰 이미지 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayReviewImagesRequestDto {
        private String imgUrl;
        private Integer reviewId;
    }

    // 원데이클래스 리뷰 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayReviewImagesResponseDto {
        private Integer imageId;
        private String imgUrl;
        private Integer reviewId;
        private Instant createdAt;
    }

    // 원데이클래스 리뷰 수정
    @Getter
    @Setter
    @ToString
    public static class OnedayReviewImagesUpdateDto {
        private Integer imageId;
        private String imgUrl;
        private Integer reviewId;
    }
}
