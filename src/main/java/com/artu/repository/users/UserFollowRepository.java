package com.artu.repository.users;

import com.artu.entity.users.activity.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow, Integer> {
    // 조회
    Optional<UserFollow> findByFollowerId_UserNoAndFolloweeId_UserNo(Integer followerId, Integer followeeId);

    // 팔로워, 팔로잉
    Long countByFollowerId_UserNo(Integer followerId);
    Long countByFolloweeId_UserNo(Integer followeeId);
}
