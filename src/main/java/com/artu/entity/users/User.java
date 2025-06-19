package com.artu.entity.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import java.time.Instant;

@Getter
@Setter
@Entity
@Where(clause = "is_used = true") // 특정 조건을 만족하는 데이터를 조회할 때 추가적인 필터를 적용하는 데 사용
// is_used = true 라는 조건을 추가하여, is_used가 true 인 항목만 조회되도록 설정
@Table(name = "users")
public class User {


    public enum UserRole {
        USER, ADMIN, MANAGER // 대문자 상수
    }

    public enum OAuthProvider {
        GOOGLE, KAKAO, NAVER, GITHUB // 대문자 상수
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @Size(max = 50)
    @NotNull
    @Column(name = "user_id", nullable = false, length = 50)
    private String userId;

    @Size(max = 255)
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "oauth")
    private OAuthProvider oauth;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "dropout_at")
    private Instant dropoutAt;

    @Column(name = "memo")
    private String memo;

}