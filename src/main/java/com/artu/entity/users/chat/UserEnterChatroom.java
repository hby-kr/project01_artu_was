package com.artu.entity.users.chat;

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
@Table(name = "user_enter_chatroom")
public class UserEnterChatroom {

    @Id
    @NotNull
    @Column(name = "chat_id", nullable = false)
    private Integer chatId;

    @Id
    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @Column(name = "entered_at")
    private Instant enteredAt;

    @Column(name = "left_at")
    private Instant leftAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;
}