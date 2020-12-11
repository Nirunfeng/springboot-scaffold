package com.example.travels.service.Impl;

import com.example.travels.dao.UserDao;
import com.example.travels.entity.User;
import com.example.travels.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/9 10:15
 * @Version：1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    /**
     * 注册业务
     * @param user
     */
    @Override
    public void register(User user) {
        if(userDao.findUserByusername(user.getUsername())==null){
            userDao.save(user);
        }else{
            throw new RuntimeException("用户名已存在,无法添加");
        }

    }

    /**
     * 登陆业务
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        /*1.根据用户名获取符合user*/
        User selectUser=userDao.findUserByusername(user.getUsername());
        if(selectUser!=null){
            if(selectUser.getPassword().equals(user.getPassword())){
                return selectUser;
            }
            throw new RuntimeException("密码不匹配");
        }else {
            throw new RuntimeException("用户名输入错误");
        }
    }
}
