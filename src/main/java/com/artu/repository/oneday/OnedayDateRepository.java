package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Repository
public interface OnedayDateRepository extends JpaRepository <OnedayDate, Integer> {
    // 원데이별 전체 일정
    Set<OnedayDate> findByOnedayClass_OnedayId(Integer onedayId);

    // 특정 기간 일정 조회
    Set<OnedayDate> findByOnedayDateBetween(LocalDate startDate, LocalDate endDate);

    // 유저별 모든 일정
    Set<OnedayDate> findByOnedayClass_User_UserNo(Integer userNo);

    // 특정 원데이클래스 특정 날짜에 존재 여부
    boolean existsByOnedayClass_onedayIdAndOnedayDate(Integer onedayId, LocalDate date);

    // 특정 원데이클래스 특정 날짜 목록
    Set<OnedayDate> findByOnedayClass_onedayIdAndOnedayDate(Integer onedayId, LocalDate date);
}
