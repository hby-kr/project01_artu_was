package com.artu.service.oneday;

import com.artu.dto.oneday.OnedayClassDto;
import com.artu.dto.oneday.OnedayImageDto;
import com.artu.entity.oneday.OnedayClass;
import com.artu.entity.oneday.OnedayDetailImage;
import com.artu.entity.oneday.OnedayImage;

import java.util.List;
import java.util.Set;

public interface OnedayClassService {
    // 원데이클래스 등록
    OnedayClassDto.OnedayClassResponseDto save(OnedayClassDto.OnedayClassRequestDto requestDto);

    // 원데이클래스 삭제
    OnedayClassDto.OnedayClassResponseDto delete(Integer onedayId);

    // 사용자 원데이클래스 조회
    Set<OnedayClassDto.OnedayClassResponseDto> findByUser_UserNo(Integer userNo);

    // 카테고리 원데이클래스 조회
    Set<OnedayClassDto.OnedayClassResponseDto> findByCategory_ctgrId(Integer ctgrId);

    // 원데이클래스 이미지 조회
    List<OnedayImageDto.OnedayImagesResponseDto> findImageByOneday_OnedayId(Integer onedayId);

    // 원데이클래스 디테일 이미지 조회
    List<OnedayImageDto.OnedayDetailImagesResponseDto> findDetailImageByOneday_OnedayId(Integer onedayId);

    // 원데이 리뷰 등록
    // 원데이 리뷰 삭제
    // 원데이 리뷰 이미지 조회
    // 원데이 옵션 조회
    // 원데이 데이트 조회
}
