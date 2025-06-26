package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayReview;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OnedayReviewRepository extends JpaRepository<OnedayReview, Integer> {
    // 전체 리뷰
    Page<OnedayReview> findAll(Pageable pageable);

    // 원데이별 리뷰
    Set<OnedayReview> findByOnedayClass_OnedayId(Integer onedayId);

    // 유저별 리뷰
    Set<OnedayReview> findByUser_UserNo(Integer userNo);

    // 원데이 카테고리별 리뷰
    Set<OnedayReview> findByOnedayClass_Category_CtgrId(Integer categoryId);

}
