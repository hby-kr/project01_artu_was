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
public class UserEventBmarkId implements Serializable {
    private static final long serialVersionUID = -5529870692378845221L;
    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @NotNull
    @Column(name = "event_id", nullable = false)
    private Integer eventId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEventBmarkId entity = (UserEventBmarkId) o;
        return Objects.equals(this.eventId, entity.eventId) &&
                Objects.equals(this.userNo, entity.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, userNo);
    }

}