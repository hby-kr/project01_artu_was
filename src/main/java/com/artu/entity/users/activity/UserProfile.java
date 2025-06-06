package com.artu.entity.users.activity;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user_profiles")
public class UserProfile {
    @Id
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User users;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 50)
    @NotNull
    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @NotNull
    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Size(max = 10)
    @NotNull
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}