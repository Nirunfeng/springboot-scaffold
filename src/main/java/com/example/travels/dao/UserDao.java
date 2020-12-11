package com.example.travels.dao;

import com.example.travels.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/9 9:53
 * @Version：1.0
 */
@Mapper
public interface UserDao {

    /**
     * 添加用户
     * @param user
     */
    public void save(User user);

    /**
     * 根据用户名查询User
     * @param username
     * @return
     */
    public User findUserByusername(String username);
}
