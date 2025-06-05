package com.artu.dto.postings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PostingCommentsDto {
    private String contents;
    private Integer postId;
    private Integer userNo;
    private Boolean isUsed;
}
