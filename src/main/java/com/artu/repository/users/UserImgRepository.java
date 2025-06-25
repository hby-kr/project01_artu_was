package com.artu.repository.users;

import com.artu.entity.users.activity.UserImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserImgRepository extends JpaRepository<UserImg, Integer> {

    Optional<UserImg> findByUserNo(Integer userNo);

}
