package com.blog.blog.controller;

import com.blog.blog.core.entity.UserEntity;
import com.blog.blog.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取最近登录12个用户的信息
     * @return 返回12个用户信息
     */
    @GetMapping("/getUserInfo")
    public Map<String, Object> geiUserInfo(){
        Map<String,Object> data = new HashMap<>();
        try{
            List<UserEntity> userEntities = userService.getUserInfo();
            data.put("data",userEntities);
            return data;
        }catch (Exception e){
            data.put("msg","查询用户失败");
            return data;
        }

    }
}
