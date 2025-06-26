package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnedayOptionRepository extends JpaRepository<OnedayOption, Integer> {
    // 원데이 데이트별 옵션
    List<OnedayOption> findByOnedayDate_DateId(Integer dateId);

    // 원데이별 옵션
    List<OnedayOption> findByOnedayDate_OnedayClass_OnedayId(Integer onedayId);
}
