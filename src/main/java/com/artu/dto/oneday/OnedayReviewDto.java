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
        private Integer onedayId;
        private String contents;
        private Integer rate;
        private Instant createdAt;
        private Boolean isUsed;
    }
}
