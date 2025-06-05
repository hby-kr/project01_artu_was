package com.artu.dto.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInquireDto {
    private Integer userNo;
    private String inquireCategory;
    private String title;
    private String contents;
    private Integer paymentId;
    private String inquiryImgUrl;
    private String inquiryState;
    private Boolean isUsed;
}
