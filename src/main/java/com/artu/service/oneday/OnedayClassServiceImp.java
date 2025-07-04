//package com.artu.service.oneday;
//
//import com.artu.dto.oneday.OnedayClassDto;
//import com.artu.dto.oneday.OnedayImageDto;
//import com.artu.entity.oneday.OnedayClass;
//import com.artu.entity.oneday.OnedayDetailImage;
//import com.artu.entity.oneday.OnedayImage;
//import com.artu.mapper.oneday.OnedayClassMapper;
//import com.artu.mapper.oneday.OnedayImageMapper;
//import com.artu.repository.oneday.OnedayClassRepository;
//import com.artu.repository.oneday.OnedayImageRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class OnedayClassServiceImp implements OnedayClassService {
//    private final OnedayClassRepository onedayClassRepository;
//    private final OnedayImageRepository onedayImageRepository;
//    private final OnedayClassMapper onedayClassMapper;
//    private final OnedayImageMapper onedayImageMapper;
//
//    @Override
//    public OnedayClassDto.OnedayClassResponseDto save(OnedayClassDto.OnedayClassRequestDto requestDto) {
//        OnedayClass onedayClass = onedayClassMapper.toEntity(requestDto);
//        if (onedayClass.getUser() == null || onedayClass.getOnedayName() == null) {
//            throw new IllegalArgumentException("사용자 확인 또는 원데이클래스명 확인 필요");
//        }
//        OnedayClass savedOnedayClass = onedayClassRepository.save(onedayClass);
//        return onedayClassMapper.toResponseDto(savedOnedayClass);
//    }
//
//    @Override
//    public OnedayClassDto.OnedayClassResponseDto deleteOneday(Integer onedayId) {
//        OnedayClass onedayClass = onedayClassRepository.findById(onedayId)
//                .orElseThrow(() -> new IllegalArgumentException("원데이클래스 없음"));
//        onedayClassRepository.delete(onedayClass);
//        return onedayClassMapper.toResponseDto(onedayClass);
//    }
//
//    @Override
//    public Page<OnedayClassDto.OnedayClassResponseDto> findAll(Pageable pageable) {
//        Page<OnedayClass> onedayClasses = onedayClassRepository.findAll(pageable);
//        return onedayClasses.map(onedayClassMapper::toResponseDto);
//    }
//
//    @Override
//    public Set<OnedayClassDto.OnedayClassResponseDto> findByUser_UserNo(Integer userNo) {
//        Set<OnedayClass> onedayClasses = onedayClassRepository.findByUser_UserNo(userNo);
//        return onedayClasses.stream()
//                .map(onedayClassMapper::toResponseDto)
//                .collect(Collectors.toSet());
//    }
//
//    @Override
//    public Set<OnedayClassDto.OnedayClassResponseDto> findByCategory_ctgrId(Integer ctgrId) {
//        Set<OnedayClass> onedayClasses = onedayClassRepository.findByCategory_ctgrId(ctgrId);
//        return onedayClasses.stream()
//                .map(onedayClassMapper::toResponseDto)
//                .collect(Collectors.toSet());
//    }
//
//    @Override
//    public List<OnedayImageDto.OnedayImagesResponseDto> findImageByOneday_OnedayId(Integer onedayId) {
//        List<OnedayImage> onedayImages = onedayImageRepository.findImageByOneday_OnedayId(onedayId);
//        return onedayImages.stream().map(onedayImageMapper::toResponseDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<OnedayImageDto.OnedayDetailImagesResponseDto> findDetailImageByOneday_OnedayId(Integer onedayId) {
//        List<OnedayDetailImage> onedayDetailImages = onedayImageRepository.findDetailImageByOneday_OnedayId(onedayId);;
//        return onedayDetailImages.stream().map(onedayImageMapper::toResponseDto).collect(Collectors.toList());
//    }
//
//}
