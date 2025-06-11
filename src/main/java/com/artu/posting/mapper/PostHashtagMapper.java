package com.artu.posting.mapper;

import com.artu.entity.postings.PostHashtag;
import com.artu.entity.postings.PostPersonTag;
import com.artu.entity.postings.PostTagLink;
import com.artu.posting.dto.PostHashtagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostHashtagMapper {
    PostHashtag toHashtagEntity(PostHashtagDto.PostingHashtagsDto postingHashtagsDto);
    PostPersonTag toPersonTagEntity(PostHashtagDto.PostingPersonTagDto postingPersonTagDto);
    PostTagLink toTagLinkEntity(PostHashtagDto.PostingTagLinkDto postingTagLinkDto);

    PostHashtagDto.PostingHashtagsDto toHashtagDto(PostHashtag postHashtag);
    PostHashtagDto.PostingPersonTagDto toPersonTagDto(PostPersonTag postPersonTag);
    PostHashtagDto.PostingTagLinkDto toTagLinkDto(PostTagLink postTagLink);
}
