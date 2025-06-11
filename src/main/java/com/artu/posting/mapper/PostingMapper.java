package com.artu.posting.mapper;

import com.artu.entity.postings.Posting;
import com.artu.posting.dto.PostingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingMapper {
    Posting toEntity(PostingDto.PostingRequestDto RequestDto);
    Posting toEntity(PostingDto.PostingResponseDto ResponseDto);
    Posting toEntity(PostingDto.PostingUpdateDto UpdateDto);

    PostingDto.PostingRequestDto toRequestDto(Posting postingEntity);
    PostingDto.PostingResponseDto toResponseDto(Posting postingEntity);
    PostingDto.PostingUpdateDto toUpdateDto(Posting postingEntity);
}
