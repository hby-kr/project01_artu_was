package com.artu.repository.users;

import com.artu.entity.users.activity.UserInquire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserInquireRepository extends JpaRepository<UserInquire, Integer> {
    // 유저 개인 문의 내역
    Set<UserInquire> findByUser_UserNo(Integer userNo);

    // 하나만
    Optional<UserInquire> findOneByUser_UserNo(Integer userNo);

    // 카테고리별
    Set<UserInquire> findByInquireCategory(String inquireCategory);
}
