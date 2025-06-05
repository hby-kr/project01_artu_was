package com.artu.entity.base;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false)
    private Integer reportId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User userNo;

    @NotNull
    @Lob
    @Column(name = "target_type", nullable = false)
    private String targetType;

    @NotNull
    @Column(name = "target_id", nullable = false)
    private Integer targetId;

    @Size(max = 255)
    @NotNull
    @Column(name = "reason", nullable = false)
    private String reason;

    @ColumnDefault("'pending'")
    @Lob
    @Column(name = "status")
    private String status;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "reported_at", nullable = false)
    private Instant reportedAt;

    @Size(max = 255)
    @NotNull
    @Column(name = "reviewed_by", nullable = false)
    private String reviewedBy;

    @Column(name = "reviewed_at")
    private Instant reviewedAt;

}