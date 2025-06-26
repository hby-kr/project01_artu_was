package com.artu.dto.oneday;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

public class OnedayImageDto {
    // 이미지 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayImagesRequestDto {
        private Integer onedayId;
        private String imgUrl;
        private Integer imgOrder;
    }

    // 이미지 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayImagesResponseDto {
        private Integer imgId;
        private Integer onedayId;
        private String imgUrl;
        private Integer imgOrder;
        private Instant createdAt;
    }

    // 이미지 업데이트
    @Getter
    @Setter
    @ToString
    public static class OnedayImagesUpdateDto {
        private Integer imgId;
        private Integer onedayId;
        private String imgUrl;
        private Integer imgOrder;
        private Instant createdAt;
    }

    // 디테일 이미지 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayDetailImagesRequestDto {
        private Integer onedayId;
        private String imgUrl;
        private Integer imgOrder;
    }

    // 디테일 이미지 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayDetailImagesResponseDto {
        private Integer detailImgId;
        private Integer onedayId;
        private String imgUrl;
        private Integer imgOrder;
        private Instant createdAt;
    }


}
