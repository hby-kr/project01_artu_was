package com.artu.repository.oneday;

import com.artu.entity.oneday.OnedayClass;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.Set;

@Repository
public interface OnedayClassRepository extends JpaRepository<OnedayClass, Integer> {
    // oneday 전체 목록
    Page<OnedayClass> findAll(Pageable pageable);

    // 유저별 목록
    Set<OnedayClass> findByUser_UserNo(Integer userNo);

    // 카테고리별 목록
    Set<OnedayClass> findByCategory_ctgrId(Integer ctgrId);

}
