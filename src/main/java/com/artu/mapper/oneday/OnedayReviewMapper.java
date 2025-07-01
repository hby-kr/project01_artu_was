package com.artu.mapper.oneday;

import com.artu.dto.oneday.OnedayReviewDto;
import com.artu.entity.oneday.OnedayClass;
import com.artu.entity.oneday.OnedayReview;
import com.artu.entity.oneday.OnedayReviewImage;
import com.artu.entity.users.User;
import org.mapstruct.Mapping;

public interface OnedayReviewMapper {
    @Mapping(target = "reviewId", ignore = true)
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "isUsed", constant = "true")
    OnedayReview toEntity(OnedayReviewDto.OnedayReviewRequestDto dto);

    @Mapping(target = "reviewId", source = "reviewId")
    @Mapping(target = "user.userNo", source = "userNo")
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "rate", source = "rate")
    OnedayReview toEntity(OnedayReviewDto.OnedayReviewUpdateDto dto);

    @Mapping(target = "reviewId", source = "reviewId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayReviewDto.OnedayReviewResponseDto toResponseDto(OnedayReview entity);

    @Mapping(target = "reviewId", source = "reviewId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "rate", source = "rate")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayReviewDto.OnedayReviewUpdateDto toUpdateDto(OnedayReview entity);

    @Mapping(target = "imgId", ignore = true)
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "onedayReview", source = "reviewId")
    @Mapping(target = "isUsed", constant = "true")
    OnedayReviewImage toEntity(OnedayReviewDto.OnedayReviewImagesRequestDto dto);

    @Mapping(target = "imgId", source = "imageId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "onedayReview", source = "reviewId")
    OnedayReviewImage toEntity(OnedayReviewDto.OnedayReviewImagesUpdateDto dto);

    @Mapping(target = "imageId", source = "imgId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "reviewId", source = "onedayReview.reviewId")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayReviewDto.OnedayReviewImagesResponseDto toResponseDto(OnedayReviewImage entity);

    @Mapping(target = "imageId", source = "imgId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "reviewId", source = "onedayReview.reviewId")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayReviewDto.OnedayReviewImagesUpdateDto toUpdateDto(OnedayReviewImage entity);

    default User mapUser(Integer userNo) {
        if (userNo == null) return null;
        User user = new User();
        user.setUserNo(userNo);
        return user;
    }

    default OnedayClass mapOneday(Integer onedayId) {
        if (onedayId == null) return null;
        OnedayClass oneday = new OnedayClass();
        oneday.setOnedayId(onedayId);
        return oneday;
    }

    default OnedayReview mapReview(Integer reviewId) {
        if (reviewId == null) return null;
        OnedayReview review = new OnedayReview();
        review.setReviewId(reviewId);
        return review;
    }
}
