package com.artu.entity.users.payments;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @NotNull
    @Column(name = "cart_id", nullable = false)
    private Integer cartId;

    @Id
    @NotNull
    @Column(name = "item_type", nullable = false)
    private String itemType;

    @Id
    @NotNull
    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "opt_count")
    private Integer optCount;

    @NotNull
    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "added_at")
    private Instant addedAt;


}