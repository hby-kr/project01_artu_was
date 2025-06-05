package com.artu.dto.postings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostingLikeDto {
    private Integer userNo;
    private Integer postId;
    private Boolean isUsed;
}
