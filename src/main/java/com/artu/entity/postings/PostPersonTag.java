package com.artu.entity.postings;

import com.artu.entity.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@ToString
@IdClass(PostPersonTagId.class)
@Table(name = "post_person_tags")
public class PostPersonTag {
//    @EmbeddedId
//    private PostPersonTagId id;

    @Id
    @Column(name = "post_id", nullable = false)
    private Integer postId;

    @Id
    @Column(name = "user_no", nullable = false)
    private Integer userNo;

}