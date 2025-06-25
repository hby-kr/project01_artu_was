package com.artu.repository.users;

import com.artu.entity.users.User;
import com.artu.entity.users.activity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    Optional<User> findByNameAndEmail (String name, String email);
}
