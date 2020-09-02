package com.blog.blog.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blog.core.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<UserEntity>{

    public List<UserEntity> selectInofBytime();
}
