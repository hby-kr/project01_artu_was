package com.artu.entity.users.activity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UserOnedayBmarkId implements Serializable {
    private static final long serialVersionUID = -3218739281984427949L;
    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @NotNull
    @Column(name = "oneday_id", nullable = false)
    private Integer onedayId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserOnedayBmarkId entity = (UserOnedayBmarkId) o;
        return Objects.equals(this.userNo, entity.userNo) &&
                Objects.equals(this.onedayId, entity.onedayId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNo, onedayId);
    }

}