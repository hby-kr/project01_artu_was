package com.artu.repository.oneday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OnedayDateRepositoryTest {
    @Autowired
    private OnedayDateRepository onedayDateRepository;

    @Test
    void findByOnedayClass_OnedayId() {
        System.out.println(onedayDateRepository.findByOnedayClass_OnedayId(1));
    }

    @Test
    void findByOnedayDateBetween() {
        LocalDate startDate = LocalDate.of(2023, 11, 10);
        LocalDate endDate = LocalDate.of(2023, 11, 11);
        System.out.println(onedayDateRepository.findByOnedayDateBetween(startDate, endDate));
    }

    @Test
    void findByOnedayClass_User_UserNo() {
        System.out.println(onedayDateRepository.findByOnedayClass_User_UserNo(1));
    }

    @Test
    void existsByOnedayClass_onedayDate() {
        LocalDate date = LocalDate.of(2023, 11, 5);
        System.out.println(onedayDateRepository.existsByOnedayClass_onedayIdAndOnedayDate(1, date));
    }

    @Test
    void findByOnedayClass_onedayIdAndOnedayDate() {
        LocalDate date = LocalDate.of(2023, 11, 5);
        System.out.println(onedayDateRepository.findByOnedayClass_onedayIdAndOnedayDate(1, date));
    }
}