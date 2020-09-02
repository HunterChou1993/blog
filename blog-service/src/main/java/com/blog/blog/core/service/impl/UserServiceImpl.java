package com.blog.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blog.core.dao.UserDao;
import com.blog.blog.core.entity.UserEntity;
import com.blog.blog.core.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao,UserEntity> implements UserService{

    /**
     * 获取最近登录的12个用户
     * @return
     */
    @Override
    public List<UserEntity> getUserInfo() {
        List<UserEntity> data = this.baseMapper.selectInofBytime();
        return data;
    }
}
