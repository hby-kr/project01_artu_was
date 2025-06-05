package com.artu.repository.users;

import com.artu.entity.users.activity.UserImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserImageRepository extends JpaRepository<UserImg, Integer> {
    // 유저의 이미지
    Set<UserImg> findUserImgByUser_UserNo(Integer userNo);
}
