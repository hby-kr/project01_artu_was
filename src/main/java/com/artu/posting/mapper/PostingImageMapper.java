package com.artu.posting.mapper;

import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingImage;
import com.artu.posting.dto.PostingDto;
import com.artu.posting.dto.PostingImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingImageMapper {
    PostingImage toEntity(PostingImageDto.PostingImageRequestDto RequestDto);
    PostingImage toEntity(PostingImageDto.PostingImageResponseDto ResponseDto);
    PostingImage toEntity(PostingImageDto.PostingImageUpdateDto UpdateDto);

    PostingImageDto.PostingImageRequestDto toRequestDto(PostingImage postingImageEntity);
    PostingImageDto.PostingImageResponseDto toResponseDto(PostingImage postingImageEntity);
    PostingImageDto.PostingImageUpdateDto toUpdateDto(PostingImage postingImageEntity);
}
