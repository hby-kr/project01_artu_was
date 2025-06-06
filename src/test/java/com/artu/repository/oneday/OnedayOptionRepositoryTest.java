package com.artu.repository.oneday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OnedayOptionRepositoryTest {
    @Autowired
    private OnedayOptionRepository onedayOptionRepository;

    @Test
    void findByOnedayDate_DateId() {
        System.out.println(onedayOptionRepository.findByOnedayDate_DateId(1));
    }

    @Test
    void findByOnedayDate_OnedayClass_OnedayId() {
        System.out.println(onedayOptionRepository.findByOnedayDate_OnedayClass_OnedayId(1));
    }
}