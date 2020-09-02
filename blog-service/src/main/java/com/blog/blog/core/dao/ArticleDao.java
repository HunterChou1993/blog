package com.blog.blog.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blog.blog.core.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity>{

    public List<ArticleEntity> selectHotArticle();
}
