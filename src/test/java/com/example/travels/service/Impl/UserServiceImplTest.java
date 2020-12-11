package com.example.travels.service.Impl;

import com.example.travels.TravelsApplication;
import com.example.travels.entity.User;
import com.example.travels.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/9 10:22
 * @Version：1.0
 */
@SpringBootTest(classes = TravelsApplication.class)
@RunWith(SpringRunner.class)
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void Test(){
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setEmail("1234123@123");
        userService.register(user);
    }
}