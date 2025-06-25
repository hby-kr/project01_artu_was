package com.artu.repository.users;

import com.artu.entity.users.account.PasswordChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordChangeHistoryRepository extends JpaRepository<PasswordChangeHistory, Integer> {

}
