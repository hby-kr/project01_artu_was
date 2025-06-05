package com.artu.entity.users.activity;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "user_stats")
public class UserStat {
    @Id
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User users;

    @ColumnDefault("0")
    @Column(name = "following_count")
    private Integer followingCount;

    @ColumnDefault("0")
    @Column(name = "follower_count")
    private Integer followerCount;

    @ColumnDefault("0")
    @Column(name = "post_count")
    private Integer postCount;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

}