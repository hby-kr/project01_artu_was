package com.artu.entity.oneday;

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
@Table(name = "oneday_images")
public class OnedayImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id", nullable = false)
    private Integer imgId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oneday_id", nullable = false)
    private OnedayClass oneday;

    @Size(max = 255)
    @NotNull
    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @NotNull
    @Column(name = "img_order", nullable = false)
    private Integer imgOrder;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}