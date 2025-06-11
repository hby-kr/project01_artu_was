package com.artu.posting.mapper;

import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingComment;
import com.artu.posting.dto.PostingCommentDto;
import com.artu.posting.dto.PostingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostingCommentMapper {
    PostingComment toEntity(PostingCommentDto.PostingCommentRequestDto RequestDto);
    PostingComment toEntity(PostingCommentDto.PostingCommentResponseDto ResponseDto);
    PostingComment toEntity(PostingCommentDto.PostingCommentUpdateDto UpdateDto);

    PostingCommentDto.PostingCommentRequestDto toRequestDto(PostingComment postingCommentEntity);
    PostingCommentDto.PostingCommentResponseDto toResponseDto(PostingComment postingCommentEntity);
    PostingCommentDto.PostingCommentUpdateDto toUpdateDto(PostingComment postingCommentEntity);
}
