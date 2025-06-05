package com.artu.entity.users.account;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "user_settings")
public class UserSetting {

    public enum Language {ko, en, ja, zh}

    public enum DisplayColor {light, dark}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "setting_id", nullable = false)
    private Integer settingId;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @ColumnDefault("'light'")
    @Lob
    @Column(name = "display_color")
    @Enumerated(EnumType.STRING)
    private DisplayColor displayColor;

    @ColumnDefault("'ko'")
    @Lob
    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "set_at")
    private Instant setAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

}