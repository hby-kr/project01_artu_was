package com.artu.repository.users;

import com.artu.entity.users.account.PasswordChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordChangeHistoryRepository extends JpaRepository<PasswordChangeHistory, Integer> {

    Optional<PasswordChangeHistory> findByUserNo(Integer userNo);
}
