package com.artu.repository.users;

import com.artu.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    boolean existsByUserId(String userId);

    Optional<User> findByUserId(String userId);
    Optional<User> findByEmail(String email);

}
