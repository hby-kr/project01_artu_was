package com.artu.entity.users.payments;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class CartItemId implements Serializable {
    private static final long serialVersionUID = -5794292581883397220L;

    @NotNull
    @Column(name = "cart_id", nullable = false)
    private Integer cartId;

    @NotNull
    @Column(name = "item_type", nullable = false)
    private String itemType;

    @NotNull
    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CartItemId entity = (CartItemId) o;
        return Objects.equals(this.itemId, entity.itemId) &&
                Objects.equals(this.itemType, entity.itemType) &&
                Objects.equals(this.cartId, entity.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemType, cartId);
    }

}