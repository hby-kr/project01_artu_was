package com.artu.repository.oneday;

import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OnedayDetailImagesRepositoryTest {
    @Autowired
    private OnedayDetailImagesRepository onedayDetailImagesRepository;

    @Test
    void findByOneday_OnedayId() {
        System.out.println(onedayDetailImagesRepository.findByOneday_OnedayId(1));
    }
}