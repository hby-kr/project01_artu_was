package com.artu.repository.users;

import com.artu.entity.users.activity.UserStat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatRepository extends JpaRepository<UserStat, Integer> {

}
