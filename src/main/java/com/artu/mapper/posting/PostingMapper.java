package com.artu.mapper.posting;

import com.artu.entity.postings.Posting;
import com.artu.dto.posting.PostingDto;
import com.artu.entity.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostingMapper {
    @Mapping(target = "postId", ignore = true)
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "editedAt", ignore = true)
    @Mapping(target = "isUsed", constant = "true")
    @Mapping(target = "memo", ignore = true)
    @Mapping(target = "isReported", constant = "false")
    @Mapping(target = "likeCount", constant = "0")
    Posting toEntity(PostingDto.PostingRequestDto RequestDto);

    // Posting toEntity(PostingDto.PostingResponseDto ResponseDto);

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "user", source = "userNo") // userNo → User
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "editedAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "isUsed", ignore = true)
    @Mapping(target = "memo", ignore = true)
    @Mapping(target = "isReported", ignore = true)
    @Mapping(target = "likeCount", ignore = true)
    Posting toEntity(PostingDto.PostingUpdateDto UpdateDto);

    @Mapping(target = "userNo", source = "user.userNo")
    PostingDto.PostingRequestDto toRequestDto(Posting postingEntity);

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "likeCount", source = "likeCount")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "editedAt", source = "editedAt")
    @Mapping(target = "isReported", source = "isReported")
    PostingDto.PostingResponseDto toResponseDto(Posting postingEntity);

    @Mapping(target = "postId", source = "postId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "contents", source = "contents")
    @Mapping(target = "visibilityType", source = "visibilityType")
    @Mapping(target = "editedAt", source = "editedAt")
    PostingDto.PostingUpdateDto toUpdateDto(Posting postingEntity);

    default User map(Integer userNo) {
        if (userNo == null) return null;
        User user = new User();
        user.setUserNo(userNo);
        return user;
    }
}
