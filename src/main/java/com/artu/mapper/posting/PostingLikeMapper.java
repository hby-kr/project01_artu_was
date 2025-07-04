package com.artu.mapper.posting;

import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingLike;
import com.artu.dto.posting.PostingLikeDto;
import com.artu.entity.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostingLikeMapper {
//    @Mapping(target = "postingLikeId.userNo", source = "userNo")
//    @Mapping(target = "postingLikeId.postId", source = "postId")
    @Mapping(target = "userNo", source = "userNo")
    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "likedAt", ignore = true)
    @Mapping(target = "isUsed", constant = "true")
    PostingLike toEntity(PostingLikeDto postingLikeDto);

    @Mapping(source = "userNo", target = "userNo")
    @Mapping(source = "postId", target = "postId")
    PostingLikeDto toDto(PostingLike postingLikeEntity);

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
