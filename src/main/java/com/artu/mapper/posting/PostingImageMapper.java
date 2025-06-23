package com.artu.mapper.posting;

import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingImage;
import com.artu.dto.posting.PostingImageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostingImageMapper {
    @Mapping(target = "imgId", ignore = true)
    @Mapping(target = "post", source = "postId")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "isUsed", constant = "true")
    PostingImage toEntity(PostingImageDto.PostingImageRequestDto RequestDto);

    @Mapping(target = "post", source = "postId")
    @Mapping(target = "isUsed", ignore = true)
    PostingImage toEntity(PostingImageDto.PostingImageResponseDto ResponseDto);

    @Mapping(target = "post", source = "postId")
    @Mapping(target = "isUsed", ignore = true)
    PostingImage toEntity(PostingImageDto.PostingImageUpdateDto UpdateDto);

    @Mapping(target = "postId", source = "post.postId")
    PostingImageDto.PostingImageRequestDto toRequestDto(PostingImage postingImageEntity);

    @Mapping(target = "imgId", source = "imgId")
    @Mapping(target = "postId", source = "post.postId")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "createdAt", source = "createdAt")
    PostingImageDto.PostingImageResponseDto toResponseDto(PostingImage postingImageEntity);

    @Mapping(target = "imgId", source = "imgId")
    @Mapping(target = "postId", source = "post.postId")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "createdAt", source = "createdAt")
    PostingImageDto.PostingImageUpdateDto toUpdateDto(PostingImage postingImageEntity);

    default Posting map(Integer postId) {
        if (postId == null) return null;
        Posting post = new Posting();
        post.setPostId(postId);
        return post;
    }
}
