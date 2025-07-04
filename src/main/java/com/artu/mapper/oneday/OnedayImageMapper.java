package com.artu.mapper.oneday;

import com.artu.dto.oneday.OnedayImageDto;
import com.artu.entity.oneday.OnedayClass;
import com.artu.entity.oneday.OnedayDetailImage;
import com.artu.entity.oneday.OnedayImage;
import org.mapstruct.Mapping;

public interface OnedayImageMapper {
    @Mapping(target = "imgId", ignore = true)
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "isUsed", constant = "true")
    OnedayImage toEntity(OnedayImageDto.OnedayImagesRequestDto dto);

    @Mapping(target = "imgId", source = "imgId")
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    OnedayImage toEntity(OnedayImageDto.OnedayImagesUpdateDto dto);

    @Mapping(target = "imgId", source = "imgId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayImageDto.OnedayImagesResponseDto toResponseDto(OnedayImage entity);

    @Mapping(target = "imgId", source = "imgId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayImageDto.OnedayImagesUpdateDto toUpdateDto(OnedayImage entity);

    @Mapping(target = "detailImgId", ignore = true)
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "isUsed", constant = "true")
    OnedayDetailImage toEntity(OnedayImageDto.OnedayDetailImagesRequestDto dto);

    @Mapping(target = "detailImgId", source = "detailImgId")
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    OnedayDetailImage toEntity(OnedayImageDto.OnedayDetailImagesUpdateDto dto);

    @Mapping(target = "detailImgId", source = "detailImgId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayImageDto.OnedayDetailImagesResponseDto toResponseDto(OnedayDetailImage entity);

    @Mapping(target = "detailImgId", source = "detailImgId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "imgUrl", source = "imgUrl")
    @Mapping(target = "imgOrder", source = "imgOrder")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayImageDto.OnedayDetailImagesUpdateDto toUpdateDto(OnedayDetailImage entity);

    default OnedayClass mapOneday(Integer onedayId) {
        if (onedayId == null) return null;
        OnedayClass oneday = new OnedayClass();
        oneday.setOnedayId(onedayId);
        return oneday;
    }

}
