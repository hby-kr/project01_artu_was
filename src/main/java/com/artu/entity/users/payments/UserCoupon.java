package com.artu.entity.users.payments;

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
@Table(name = "user_coupons")
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_coupon_id", nullable = false)
    private Integer couponId;

    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "issued_at")
    private Instant issuedAt;

    @Column(name = "used_at")
    private Instant usedAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

}