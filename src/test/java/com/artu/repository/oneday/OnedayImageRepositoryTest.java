package com.artu.repository.oneday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OnedayImageRepositoryTest {
    @Autowired
    private OnedayImageRepository onedayImageRepository;

    @Test
    void findByOneday_OnedayId() {
        System.out.println(onedayImageRepository.findByOneday_OnedayId(1));
    }

    @Test
    void findByOneday_OnedayIdAndImgOrder() {
        System.out.println(onedayImageRepository.findByOneday_OnedayIdAndImgOrder(1,1));
    }
}