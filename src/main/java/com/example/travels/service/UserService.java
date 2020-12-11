package com.example.travels.service;

import com.example.travels.entity.User;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/9 10:13
 * @Version：1.0
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void register(User user);

    public User login(User user);
}
