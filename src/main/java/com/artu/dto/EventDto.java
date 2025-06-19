package com.artu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class EventDto {

    @Getter
    @Setter
    @ToString
    public static class eventMainPageDto {
        private int eventId;
        private String title;
        private String eventImageUrl;
    }



}
