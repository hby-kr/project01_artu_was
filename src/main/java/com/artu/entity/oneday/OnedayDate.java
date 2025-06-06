package com.artu.entity.oneday;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "oneday_dates")
public class OnedayDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "date_id", nullable = false)
    private Integer dateId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oneday_id", nullable = false)
    private OnedayClass onedayClass;

    @NotNull
    @Column(name = "oneday_price", nullable = false)
    private Integer onedayPrice;

    @NotNull
    @Column(name = "oneday_date", nullable = false)
    private LocalDate onedayDate;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}