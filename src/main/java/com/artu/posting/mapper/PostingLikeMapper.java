package com.artu.posting.mapper;

import com.artu.entity.postings.PostingLike;
import com.artu.posting.dto.PostingLikeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingLikeMapper {
    PostingLike toEntity(PostingLikeDto postingLikeDto);

    PostingLikeDto toDto(PostingLike postingLikeEntity);
}
