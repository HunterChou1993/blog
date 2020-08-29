package com.blog.blog.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.blog.core.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity>{
}
