package com.artu.mapper.posting;

import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingComment;
import com.artu.dto.posting.PostingCommentDto;
import com.artu.entity.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostingCommentMapper {
    @Mapping(target = "commentId", ignore = true)
    @Mapping(target = "post", source = "postId")
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "isUsed", constant = "true")
    @Mapping(target = "memo", ignore = true)
    PostingComment toEntity(PostingCommentDto.PostingCommentRequestDto RequestDto);

    @Mapping(target = "post", source = "postId")
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "isUsed", ignore = true)
    @Mapping(target = "memo", ignore = true)
    PostingComment toEntity(PostingCommentDto.PostingCommentResponseDto ResponseDto);

    @Mapping(target = "post", source = "postId")
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "isUsed", ignore = true)
    @Mapping(target = "memo", ignore = true)
    PostingComment toEntity(PostingCommentDto.PostingCommentUpdateDto UpdateDto);

    @Mapping(target = "postId", source = "post.postId")
    @Mapping(target = "userNo", source = "user.userNo")
    PostingCommentDto.PostingCommentRequestDto toRequestDto(PostingComment postingCommentEntity);

    @Mapping(target = "commentId", source = "commentId")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "postId", source = "post.postId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "parentCommentId", source = "parentCommentId")
    PostingCommentDto.PostingCommentResponseDto toResponseDto(PostingComment postingCommentEntity);

    @Mapping(target = "commentId", source = "commentId")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "postId", source = "post.postId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "parentCommentId", source = "parentCommentId")
    @Mapping(target = "createdAt", source = "createdAt")
    PostingCommentDto.PostingCommentUpdateDto toUpdateDto(PostingComment postingCommentEntity);

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
}
