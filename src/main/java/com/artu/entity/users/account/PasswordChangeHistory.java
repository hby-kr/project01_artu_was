package com.artu.entity.users.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "password_change_histories")
public class PasswordChangeHistory {
}