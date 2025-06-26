package com.artu.mapper.posting;

import com.artu.entity.base.Hashtag;
import com.artu.entity.postings.PostHashtag;
import com.artu.entity.postings.PostPersonTag;
import com.artu.entity.postings.PostTagLink;
import com.artu.dto.posting.PostHashtagDto;
import com.artu.entity.postings.Posting;
import com.artu.entity.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostHashtagMapper {
    @Mapping(target = "postHashtagId.tagId", source = "tagId")
    @Mapping(target = "postHashtagId.postId", source = "postId")
    @Mapping(target = "hashtag", source = "tagId")
    @Mapping(target = "post", source = "postId")
    PostHashtag toHashtagEntity(PostHashtagDto.PostingHashtagsDto postingHashtagsDto);

    @Mapping(target = "id.postId", source = "postId")
    @Mapping(target = "id.userNo", source = "userNo")
    @Mapping(target = "post", source = "postId")
    @Mapping(target = "user", source = "userNo")
    PostPersonTag toPersonTagEntity(PostHashtagDto.PostingPersonTagDto postingPersonTagDto);

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "tagType", source = "tagType")
    @Mapping(target = "selectedId", source = "selectedId")
    @Mapping(target = "tagKeyword", source = "tagKeyword")
    @Mapping(target = "value", source = "value")
    PostTagLink toTagLinkEntity(PostHashtagDto.PostingTagLinkDto postingTagLinkDto);

    @Mapping(target = "tagId", source = "hashtag.tagId")
    @Mapping(target = "postId", source = "post.postId")
    PostHashtagDto.PostingHashtagsDto toHashtagDto(PostHashtag postHashtag);

    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "postId", source = "post.postId")
    PostHashtagDto.PostingPersonTagDto toPersonTagDto(PostPersonTag postPersonTag);

    @Mapping(target = "postId", source = "postId.postId")
    @Mapping(target = "tagType", source = "tagType")
    @Mapping(target = "selectedId", source = "selectedId")
    @Mapping(target = "tagKeyword", source = "tagKeyword")
    @Mapping(target = "value", source = "value")
    PostHashtagDto.PostingTagLinkDto toTagLinkDto(PostTagLink postTagLink);

    default User mapUser(Integer userNo) {
        if (userNo == null) return null;
        User user = new User();
        user.setUserNo(userNo);
        return user;
    }

    default Posting mapPost(Integer postId) {
        if (postId == null) return null;
        Posting post = new Posting();
        post.setPostId(postId);
        return post;
    }

    default Hashtag mapHashtag(Integer tagId) {
        if (tagId == null) return null;
        Hashtag tag = new Hashtag();
        tag.setTagId(tagId);
        return tag;
    }
}
