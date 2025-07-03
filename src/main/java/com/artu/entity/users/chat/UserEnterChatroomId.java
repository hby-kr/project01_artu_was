package com.artu.entity.users.chat;

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
public class UserEnterChatroomId implements Serializable {
    private static final long serialVersionUID = 120237295568307165L;
    @NotNull
    @Column(name = "chat_id", nullable = false)
    private Integer chatId;

    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEnterChatroomId entity = (UserEnterChatroomId) o;
        return Objects.equals(this.chatId, entity.chatId) &&
                Objects.equals(this.userNo, entity.userNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, userNo);
    }

}