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
@Table(name = "search_words")
public class SearchWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "keyword", nullable = false, length = 50)
    private String keyword;

    @NotNull
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "search_at")
    private Instant searchAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

}