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
@Table(name = "user_purchase_lists")
public class UserPurchaseList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User userNo;

    @NotNull
    @Lob
    @Column(name = "item_type", nullable = false)
    private String itemType;

    @NotNull
    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "opt_id")
    private Integer optId;

    @Column(name = "opt_count")
    private Integer optCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_point_id")
    private UserPoint usedPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "used_coupon_id")
    private UserCoupon usedCoupon;

    @NotNull
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @NotNull
    @Lob
    @Column(name = "purchase_state", nullable = false)
    private String purchaseState;

}