package com.artu.entity.users.payments;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "coupon_name", nullable = false, length = 100)
    private String couponName;

    @Size(max = 255)
    @Column(name = "details")
    private String details;

    @NotNull
    @Column(name = "dc_price", nullable = false)
    private Integer dcPrice;

    @Size(max = 255)
    @Column(name = "requirement")
    private String requirement;

    @Column(name = "end_date")
    private Instant endDate;

    @ColumnDefault("7")
    @Column(name = "valid_days")
    private Integer validDays;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

}