package com.artu.entity.postings;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@ToString
@SQLDelete(sql = "UPDATE postings SET is_used = false WHERE post_id = ?")
@Where(clause = "is_used = true")
@Table(name = "post_tag_links")
public class PostTagLink {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Posting postId;

    @NotNull
    @Lob
    @Column(name = "tag_type", nullable = false)
    private String tagType;

    @Column(name = "selected_id")
    private Integer selectedId;

    @Size(max = 50)
    @NotNull
    @Column(name = "tag_keyword", nullable = false, length = 50)
    private String tagKeyword;

    @Size(max = 100)
    @NotNull
    @Column(name = "value", nullable = false, length = 100)
    private String value;

}