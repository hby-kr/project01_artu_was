package com.artu.entity.events.event;

import com.artu.entity.base.Category;
import com.artu.entity.events.EventReview;
import com.artu.entity.users.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "ctgr_id", nullable = false)
    private Integer ctgrId;

    @Size(max = 100)
    @NotNull
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Size(max = 50)
    @Column(name = "location", length = 50)
    private String location;

    @Size(max = 50)
    @NotNull
    @Column(name = "company", nullable = false, length = 50)
    private String company;

    @Size(max = 100)
    @NotNull
    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @NotNull
    @ColumnDefault("'0'")
    @Lob
    @Column(name = "age_limit", nullable = false)
    private String ageLimit;

    @NotNull
    @Column(name = "how_long", nullable = false)
    private Integer howLong;

    @ColumnDefault("0")
    @Column(name = "bmarks_count")
    private Integer bmarksCount;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved = false;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "is_used", nullable = false)
    private Boolean isUsed = false;

    @Size(max = 255)
    @Column(name = "memo")
    private String memo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_no", nullable = false)
    private User user;

    @OneToMany(mappedBy = "event")
    private Set<EventCast> eventCasts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventDetailImage> eventDetailImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventImage> eventImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventReview> eventReviews = new LinkedHashSet<>();

}