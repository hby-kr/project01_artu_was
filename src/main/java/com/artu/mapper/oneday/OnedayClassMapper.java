package com.artu.mapper.oneday;

import com.artu.dto.oneday.OnedayClassDto;
import com.artu.entity.base.Category;
import com.artu.entity.oneday.OnedayClass;
import com.artu.entity.oneday.OnedayDate;
import com.artu.entity.oneday.OnedayOption;
import com.artu.entity.users.User;
import org.mapstruct.Mapping;

public interface OnedayClassMapper {
    @Mapping(target = "onedayId", ignore = true)
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "onedayName", source = "onedayName")
    @Mapping(target = "category", source = "ctgrId")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "minMem", source = "minMem")
    @Mapping(target = "maxMem", source = "maxMem")
    @Mapping(target = "bmarksCount", constant = "0")
    @Mapping(target = "isApproved", constant = "false")
    @Mapping(target = "isUsed", constant = "true")
    OnedayClass toEntity(OnedayClassDto.OnedayClassRequestDto dto);

    @Mapping(target = "onedayId", source = "onedayId")
    @Mapping(target = "user", source = "userNo")
    @Mapping(target = "onedayName", source = "onedayName")
    @Mapping(target = "category", source = "ctgrId")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "minMem", source = "minMem")
    @Mapping(target = "maxMem", source = "maxMem")
    OnedayClass toEntity(OnedayClassDto.OnedayClassUpdateDto dto);

    @Mapping(target = "onedayId", source = "onedayId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "ctgrId", source = "category.ctgrId")
    @Mapping(target = "ctgrName", source = "category.ctgrName")
    OnedayClassDto.OnedayClassResponseDto toResponseDto(OnedayClass entity);

    @Mapping(target = "onedayId", source = "onedayId")
    @Mapping(target = "userNo", source = "user.userNo")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "onedayName", source = "onedayName")
    @Mapping(target = "ctgrId", source = "category.ctgrId")
    @Mapping(target = "ctgrName", source = "category.ctgrName")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "minMem", source = "minMem")
    @Mapping(target = "maxMem", source = "maxMem")
    OnedayClassDto.OnedayClassUpdateDto toUpdateDto(OnedayClass entity);

    @Mapping(target = "dateId", ignore = true)
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "onedayPrice", source = "onedayPrice")
    @Mapping(target = "onedayDate", source = "onedayDate")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    @Mapping(target = "isUsed", constant = "true")
    OnedayDate toEntity(OnedayClassDto.OnedayDatesRequestDto dto);

    @Mapping(target = "dateId", source = "dateId")
    @Mapping(target = "onedayClass", source = "onedayId")
    @Mapping(target = "onedayPrice", source = "onedayPrice")
    @Mapping(target = "onedayDate", source = "onedayDate")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    OnedayDate toEntity(OnedayClassDto.OnedayDatesUpdateDto dto);

    @Mapping(target = "dateId", source = "dateId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "onedayPrice", source = "onedayPrice")
    @Mapping(target = "onedayDate", source = "onedayDate")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    OnedayClassDto.OnedayDatesResponseDto toResponseDto(OnedayDate entity);

    @Mapping(target = "dateId", source = "dateId")
    @Mapping(target = "onedayId", source = "onedayClass.onedayId")
    @Mapping(target = "onedayPrice", source = "onedayPrice")
    @Mapping(target = "onedayDate", source = "onedayDate")
    @Mapping(target = "startTime", source = "startTime")
    @Mapping(target = "endTime", source = "endTime")
    OnedayClassDto.OnedayDatesUpdateDto toUpdateDto(OnedayDate entity);

    @Mapping(target = "optId", ignore = true)
    @Mapping(target = "onedayDate", source = "dateId")
    @Mapping(target = "optName", source = "optName")
    @Mapping(target = "optPrice", source = "optPrice")
    @Mapping(target = "isUsed", constant = "true")
    OnedayOption toEntity(OnedayClassDto.OnedayOptionRequestDto dto);

    @Mapping(target = "optId", source = "optId")
    @Mapping(target = "onedayDate", source = "dateId")
    @Mapping(target = "optName", source = "optName")
    @Mapping(target = "optPrice", source = "optPrice")
    OnedayOption toEntity(OnedayClassDto.OnedayOptionUpdateDto dto);

    @Mapping(target = "optId", source = "optId")
    @Mapping(target = "dateId", source = "onedayDate.dateId")
    @Mapping(target = "optName", source = "optName")
    @Mapping(target = "optPrice", source = "optPrice")
    @Mapping(target = "createdAt", source = "createdAt")
    OnedayClassDto.OnedayOptionResponseDto toResponseDto(OnedayOption entity);

    @Mapping(target = "optId", source = "optId")
    @Mapping(target = "dateId", source = "onedayDate.dateId")
    @Mapping(target = "optName", source = "optName")
    @Mapping(target = "optPrice", source = "optPrice")
    OnedayClassDto.OnedayOptionUpdateDto toUpdateDto(OnedayOption entity);

    default User map(Integer userNo) {
        if (userNo == null) return null;
        User user = new User();
        user.setUserNo(userNo);
        return user;
    }

    default Category mapCategory(Integer ctgrId) {
        if (ctgrId == null) return null;
        Category category = new Category();
        category.setCtgrId(ctgrId);
        return category;
    }

    default OnedayClass mapOnedayClass(Integer onedayId) {
        if (onedayId == null) return null;
        OnedayClass onedayClass = new OnedayClass();
        onedayClass.setOnedayId(onedayId);
        return onedayClass;
    }

    default OnedayDate mapOnedayDate(Integer dateId) {
        if (dateId == null) return null;
        OnedayDate onedayDate = new OnedayDate();
        onedayDate.setDateId(dateId);
        return onedayDate;
    }
}
