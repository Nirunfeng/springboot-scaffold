package com.example.travels.service.Impl;

import com.example.travels.TravelsApplication;
import com.example.travels.service.ProvinceService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/13 13:34
 * @Version：1.0
 */
@SpringBootTest(classes = TravelsApplication.class)
@RunWith(SpringRunner.class)
class ProvinceServiceImplTest {

    @Resource
    private ProvinceService provinceService;

    @Test
    public void testfindByPage() {
        provinceService.findByPage(1,5);
    }

    @Test
    void findTotals() {
    }
}