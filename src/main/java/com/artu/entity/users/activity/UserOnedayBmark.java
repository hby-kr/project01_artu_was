package com.artu.entity.users.activity;

import com.artu.entity.oneday.OnedayClass;
import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@IdClass(UserOnedayBmarkId.class)
@Table(name = "user_oneday_bmarks")
public class UserOnedayBmark {
//    @EmbeddedId
//    private UserOnedayBmarkId id;

    @Id
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @Id
    @Column(name = "oneday_id", nullable = false)
    private Integer onedayId;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}