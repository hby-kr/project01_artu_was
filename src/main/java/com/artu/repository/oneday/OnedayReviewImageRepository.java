package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayImage;
import com.artu.entity.oneday.OnedayReviewImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OnedayReviewImageRepository extends JpaRepository<OnedayReviewImage, Integer> {
    // 전체 리뷰 이미지
    List<OnedayReviewImage> findAll();

    // 리뷰별 이미지 조회
    List<OnedayReviewImage> findByOnedayReview_reviewId(Integer reviewId);
}
