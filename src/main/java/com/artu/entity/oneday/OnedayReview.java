package com.artu.entity.oneday;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@Table(name = "oneday_reviews")
public class OnedayReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private Integer reviewId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oneday_id", nullable = false)
    private OnedayClass onedayClass;

    @Lob
    @Column(name = "contents")
    private String contents;

    @NotNull
    @Column(name = "rate", nullable = false)
    private Integer rate;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

    @Size(max = 255)
    @Column(name = "memo")
    private String memo;

}