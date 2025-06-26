package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayImage;
import com.artu.entity.postings.PostingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OnedayImageRepository extends JpaRepository<OnedayImage, Integer> {
    // 원데이 이미지 조회
    List<OnedayImage> findByOneday_OnedayId(Integer onedayId);

    // 원데이 대표 이미지 조회
    Optional<OnedayImage> findByOneday_OnedayIdAndImgOrder(Integer onedayId, Integer imgOrder);

}
