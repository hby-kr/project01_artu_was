package com.artu.dto.oneday;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class OnedayClassDto {
    // 원데이클래스 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayClassRequestDto {
        private Integer userNo;
        private String onedayName;
        private Integer ctgrId;
        private String location;
        private String address;
        private Integer minMem;
        private Integer maxMem;
    }

    // 원데이클래스 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayClassResponseDto {
        private Integer onedayId;
        private Integer userNo;
        private String userId;
        private String onedayName;
        private Integer ctgrId;
        private String ctgrName;
        private String location;
        private String address;
        private Integer minMem;
        private Integer maxMem;
        private Integer bmarksCount;
        private Boolean isApproved;
    }

    // 원데이클래스 업데이트


    // 원데이 데이트 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayDatesRequestDto {
        private Integer onedayId;
        private Integer onedayPrice;
        private LocalDate onedayDate;
        private LocalTime startTime;
        private LocalTime endTime;
    }

    // 원데이 데이트 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayDatesResponseDto {
        private Integer dateId;
        private Integer onedayId;
        private Integer onedayPrice;
        private LocalDate onedayDate;
        private LocalTime startTime;
        private LocalTime endTime;
    }

    // 옵션 등록
    @Getter
    @Setter
    @ToString
    public static class OnedayOptionRequestDto {
        private Integer dateId;
        private String optName;
        private Integer optPrice;
    }

    // 옵션 조회
    @Getter
    @Setter
    @ToString
    public static class OnedayOptionResponseDto {
        private Integer optId;
        private Integer dateId;
        private String optName;
        private Integer optPrice;
        private Instant createdAt;
    }
}
