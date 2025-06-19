package com.artu.repository.users;

import com.artu.entity.users.activity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);
}
