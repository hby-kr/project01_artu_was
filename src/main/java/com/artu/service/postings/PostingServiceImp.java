package com.artu.service.postings;

import com.artu.dto.posting.PostingDto;
import com.artu.dto.posting.PostingImageDto;
import com.artu.entity.postings.Posting;
import com.artu.entity.postings.PostingImage;
import com.artu.mapper.posting.PostingImageMapper;
import com.artu.mapper.posting.PostingMapper;
import com.artu.repository.postings.PostingImageRepository;
import com.artu.repository.postings.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.artu.service.postings.PostingService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostingServiceImp implements PostingService {
    private final PostingRepository postingRepository;
    private final PostingImageRepository postingImageRepository;
    private final PostingMapper postingMapper;
    private final PostingImageMapper postingImageMapper;

    @Override
    public PostingDto.PostingResponseDto save(PostingDto.PostingRequestDto requestDto) {
        Posting posting = postingMapper.toEntity(requestDto);
        if (posting.getUser() == null || posting.getUser().getUserNo() == null) {
            throw new IllegalArgumentException("사용자 확인 필요");
        }
        Posting saved = postingRepository.save(posting);
        return postingMapper.toResponseDto(saved);
    }

    @Override
    public PostingDto.PostingResponseDto delete(Integer postId) {
        Posting postingDelete = postingRepository.findById(postId)
                .orElseThrow(() -> new NoSuchElementException("게시글 없음"));
        postingRepository.delete(postingDelete);
        return postingMapper.toResponseDto(postingDelete);
    }

    @Override
    public List<PostingDto.PostingResponseDto> findByUser_UserNo(Integer userNo) {
        List<Posting> postings = postingRepository.findByUser_UserNo(userNo);
        return postings.stream()
                .map(postingMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostingDto.PostingResponseDto findByPostId(Integer postId) {
        Posting posting = postingRepository.findByPostId(postId);
        if (posting == null) {
            throw new NoSuchElementException("게시글 없음");
        }
        return postingMapper.toResponseDto(posting);
    }

    @Override
    public List<PostingImageDto.PostingImageResponseDto> findByPostId(Integer postId) {
        List<PostingImage> postingImage = postingImageRepository.findByPostId(postId);
        return postingImage.stream()
                .map(postingImageMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
