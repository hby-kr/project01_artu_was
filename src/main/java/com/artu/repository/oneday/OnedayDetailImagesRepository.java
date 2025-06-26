package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayDetailImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnedayDetailImagesRepository extends JpaRepository <OnedayDetailImage, Integer> {
    // 원데이 상세 이미지 조회
    List<OnedayDetailImage> findByOneday_OnedayId(Integer onedayId);
}
