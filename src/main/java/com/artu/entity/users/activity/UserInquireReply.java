package com.artu.entity.users.activity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@SQLDelete(sql = "UPDATE postings SET is_used = false WHERE post_id = ?")
@Where(clause = "is_used = true")
@Table(name = "user_inquire_replies")
public class UserInquireReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id", nullable = false)
    private Integer replyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquire_id")
    private UserInquire inquireId;

    @NotNull
    @Lob
    @Column(name = "reply_contents", nullable = false)
    private String replyContents;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "replied_at")
    private Instant repliedAt;

    @Size(max = 255)
    @NotNull
    @Column(name = "counselor_id", nullable = false)
    private String counselorId;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}