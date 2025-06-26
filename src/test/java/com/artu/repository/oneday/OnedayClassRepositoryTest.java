package com.artu.repository.oneday;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OnedayClassRepositoryTest {
    @Autowired
    private OnedayClassRepository onedayClassRepository;

    @Test
    void findAll() {
        System.out.println(onedayClassRepository.findAll());
    }

    @Test
    void findByUser_UserNo() {
        System.out.println(onedayClassRepository.findByUser_UserNo(1));
    }

    @Test
    void findByCategory_ctgrId() {
        System.out.println(onedayClassRepository.findByCategory_ctgrId(1));
    }
}