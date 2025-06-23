package com.artu.dto.posting;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class PostingLikeDto {
    private Integer userNo;
    private Integer postId;
    private Instant likedAt;
}
