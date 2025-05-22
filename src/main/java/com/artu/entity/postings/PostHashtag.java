package com.artu.entity.postings;

import com.artu.entity.base.Hashtag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "post_hashtags")
public class PostHashtag {
    @EmbeddedId
    private PostHashtagId id;

    @MapsId("tagId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tag_id", nullable = false)
    private Hashtag tag;

}