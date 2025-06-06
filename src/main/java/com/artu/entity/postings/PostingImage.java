package com.artu.entity.postings;

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
@Table(name = "posting_images")
public class PostingImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id", nullable = false)
    private Integer imgId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private Posting post;

    @NotNull
    @Column(name = "img_order", nullable = false)
    private Integer imgOrder;

    @Size(max = 255)
    @NotNull
    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;


}