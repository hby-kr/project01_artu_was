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
public class UserInterestId implements Serializable {
    private static final long serialVersionUID = -511504269715434296L;
    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @NotNull
    @Column(name = "ctgr_id", nullable = false)
    private Byte ctgrId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserInterestId entity = (UserInterestId) o;
        return Objects.equals(this.ctgrId, entity.ctgrId) &&
                Objects.equals(this.userNo, entity.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ctgrId, userNo);
    }

}