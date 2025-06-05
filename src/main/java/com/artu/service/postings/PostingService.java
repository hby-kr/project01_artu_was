package com.artu.service.postings;

import com.artu.dto.postings.PostingDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface PostingService {
    PostingDto save(PostingDto postingDto);
    void delete(Integer postId, Integer userNo);
    Set<PostingDto> findByUserNo(Integer userNo);
}
