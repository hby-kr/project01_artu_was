package com.artu.entity.postings;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@IdClass(PostingLikeId.class)
@Table(name = "posting_like")
public class PostingLike {
//    @EmbeddedId
//    private PostingLikeId postingLikeId;

    @Id
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @Id
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "liked_at")
    private Instant likedAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}