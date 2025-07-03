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
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "msg_id", nullable = false)
    private Integer msgId;

    @NotNull
    @Column(name = "chat_id", nullable = false)
    private Integer chatId;

    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @NotNull
    @Column(name = "msg_body", nullable = false)
    private String msgBody;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "read_at")
    private Instant readAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

}