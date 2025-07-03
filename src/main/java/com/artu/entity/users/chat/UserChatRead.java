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
@Table(name = "user_chat_reads")
public class UserChatRead {

    @Id
    @NotNull
    @Column(name = "chat_id", nullable = false)
    private Integer chatId;

    @Id
    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @NotNull
    @Column(name = "last_read_msg_id", nullable = false)
    private Integer lastReadMsg;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

}