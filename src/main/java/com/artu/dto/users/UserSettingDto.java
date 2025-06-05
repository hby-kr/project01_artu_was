package com.artu.dto.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
public class UserSettingDto {
    private Integer userNo;
    private String displayColor;
    private String language;
    private Instant setAt;
    private Boolean isUsed;
}
