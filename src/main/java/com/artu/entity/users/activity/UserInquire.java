package com.artu.entity.users.activity;

import com.artu.entity.users.User;
import com.artu.entity.users.payments.UserPurchaseList;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@ToString
@Table(name = "user_inquires")
public class UserInquire {

    public enum InquireCategory {account, payment, event, oneday, etc}

    public enum InquiryState {pending, completed}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquire_id", nullable = false)
    private Integer inquireId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @ColumnDefault("'etc'")
    @Lob
    @Column(name = "inquire_category")
    @Enumerated(EnumType.STRING)
    private InquireCategory inquireCategory;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Lob
    @Column(name = "contents", nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "payment_id")
    private UserPurchaseList payment;

    @Size(max = 255)
    @Column(name = "inquiry_img_url")
    private String inquiryImgUrl;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("'pending'")
    @Lob
    @Column(name = "inquiry_state")
    @Enumerated(EnumType.STRING)
    private InquiryState inquiryState;

    @Column(name = "state_updated_at")
    private Instant stateUpdatedAt;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

}