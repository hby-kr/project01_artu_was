package com.artu.entity.postings;

import com.artu.entity.base.Hashtag;
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
@SQLDelete(sql = "UPDATE postings SET is_used = false WHERE post_id = ?")
@Where(clause = "is_used = true")
@Table(name = "post_hashtags")
public class PostHashtag {
    @EmbeddedId
    private PostHashtagId postHashtagId;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private Hashtag tagId;

}