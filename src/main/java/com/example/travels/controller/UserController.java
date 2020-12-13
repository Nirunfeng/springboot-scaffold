package com.example.travels.controller;

import com.example.travels.dto.ResultState;
import com.example.travels.entity.User;
import com.example.travels.service.UserService;
import com.example.travels.utils.CreateImageCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/8 15:27
 * @Version：1.0
 */
@RestController
@RequestMapping("user")
@CrossOrigin            //允许跨域访问的注解
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 校验码
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("getImage")
    public Map<String,String> getImage(HttpServletRequest request) throws IOException {
        Map<String,String> map=new HashMap<>();
        CreateImageCode createImageCode=new CreateImageCode();
        //1.获取验证码
        String securityCode= createImageCode.getCode();
        log.info(securityCode);
        //2.生成时间戳key，将验证码与key绑定
        String key=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key,securityCode);
        //3.生成图片
        BufferedImage image=createImageCode.getBuffImg();
        //4.验证码图片转Base64编码
        ByteArrayOutputStream byteImage=new ByteArrayOutputStream();
        ImageIO.write(image,"png",byteImage);
        String base64=Base64Util.encode(byteImage.toString());
        /*base64.replace("/=+$/","");*/
        //5.将<key,code>与<"image",base64>存入map
        map.put("key",key);map.put("image",base64);
        return map;
    }

    /**
     * 用户注册
     * @param code
     * @param key
     * @param user
     * @param request
     * @return
     */
    @PostMapping("register")
    public ResultState register(String code, String key, @RequestBody User user, HttpServletRequest request){
        log.info("接受的验证码："+code);
        log.info("接受的user对象："+user);
        ResultState resultState=new ResultState();
        /*1.校验验证码*/
        String keyCode=(String)request.getServletContext().getAttribute(key);
        log.info(keyCode);
        try {
            if(code.equalsIgnoreCase(keyCode)){
                /*2.注册用户*/
                userService.register(user);
                resultState.setMsg("注册成功");
            }
            else{
                throw new RuntimeException("验证码错误");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            resultState.setMsg(e.getMessage()).setState(false);
        }
        /*return "OK";*/
        return resultState;
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @RequestMapping("login")
    public ResultState login(@RequestBody User user,HttpServletRequest request){
        ResultState resultState=new ResultState();
        /*调用service获取user*/
        try {
            /*登陆成功情况*/
            User loginuser=userService.login(user);
            /*登陆成功后要保存user标记*/
            request.getServletContext().setAttribute(loginuser.getId(),loginuser);
            resultState.setMsg("登录成功");
            resultState.setUserId(loginuser.getId());
        } catch (Exception e) {
            /*登录失败情况*/
            resultState.setMsg(e.getMessage());
        }
        return resultState;
    }
}