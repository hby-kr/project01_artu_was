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
@Table(name = "oneday_options")
public class OnedayOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "opt_id", nullable = false)
    private Integer optId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "date_id", nullable = false)
    private OnedayDate onedayDate;

    @Size(max = 100)
    @NotNull
    @Column(name = "opt_name", nullable = false, length = 100)
    private String optName;

    @NotNull
    @Column(name = "opt_price", nullable = false)
    private Integer optPrice;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}