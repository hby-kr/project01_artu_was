package com.artu.entity.oneday;

import com.artu.entity.base.Category;
import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@ToString
@Table(name = "oneday_classes")
public class OnedayClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oneday_id", nullable = false)
    private Integer onedayId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    @ToString.Exclude
    private User user;

    @Size(max = 100)
    @NotNull
    @Column(name = "oneday_name", nullable = false, length = 100)
    private String onedayName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ctgr_id", nullable = false)
    @ToString.Exclude
    private Category category;

    @Size(max = 50)
    @NotNull
    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @Size(max = 255)
    @NotNull
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "min_mem")
    private Integer minMem;

    @NotNull
    @Column(name = "max_mem", nullable = false)
    private Integer maxMem;

    @ColumnDefault("0")
    @Column(name = "bmarks_count")
    private Integer bmarksCount;

    @NotNull
    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = false;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}