package com.blog.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blog.core.entity.UserEntity;

import java.util.List;

public interface UserService extends IService<UserEntity>{

    /**
     * 获取最近登录的12个用户
     * @return
     */
    public List<UserEntity> getUserInfo();
}
