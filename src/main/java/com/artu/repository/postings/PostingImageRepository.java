package com.artu.repository.postings;

import com.artu.entity.postings.PostingImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingImageRepository extends JpaRepository<PostingImage, Integer> {
    // 게시물 이미지 조회
    List<PostingImage> findByPost_PostId(Integer postId);
}
