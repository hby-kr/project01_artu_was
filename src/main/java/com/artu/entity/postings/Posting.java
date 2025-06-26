package com.artu.entity.postings;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@Table(name = "postings")
public class Posting implements Serializable {
    private static final long serialVersionUID = 526733583585891060L;

//    public enum VisibilityType {all, friends, private}
    // private 예약어 사용이라서 변경 필요

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @NotNull
    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @ColumnDefault("'all'")
    @Lob
    @Column(name = "visibility_type")
//    private VisibilityType visibilityType;
    private String visibilityType;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "edited_at")
    private Instant editedAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

    @Size(max = 255)
    @Column(name = "memo")
    private String memo;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "is_reported", nullable = false)
    private Boolean isReported;

    @ColumnDefault("0")
    @Column(name = "like_count")
    private Integer likeCount;

}