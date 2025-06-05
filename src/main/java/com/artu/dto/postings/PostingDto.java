package com.artu.dto.postings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostingDto {
    private Integer postId;
    private Integer userNo;
    private String contents;
    private String visibilityType;
    private Integer likeCount;
}
