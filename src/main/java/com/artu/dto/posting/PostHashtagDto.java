package com.artu.dto.posting;

import com.artu.entity.postings.PostTagLink;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class PostHashtagDto {
    // 게시물-태그 등록/조회/수정
    @Getter
    @Setter
    @ToString
    public static class PostingHashtagsDto {
        private Integer postId;
        private Integer tagId;
    }

    // 게시물-사람태그 등록/조회/수정
    @Getter
    @Setter
    @ToString
    public static class PostingPersonTagDto {
        private Integer postId;
        private Integer userNo;
        private String userId;
    }

    // 게시물-태그 연결 등록/조회/수정
    @Getter
    @Setter
    @ToString
    public static class PostingTagLinkDto {
        private Integer postId;
        private PostTagLink.TagType tagType;
        private Integer selectedId;
        private String tagKeyword;
        private String value;
    }
}
