package com.blog.blog.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blog.core.entity.ArticleEntity;

import java.util.List;
import java.util.Map;

/**
 * 文章相关的接口
 */
public interface ArticleService extends IService<ArticleEntity>{

    public List<ArticleEntity> selectHotArtcile();

    /**
     * 首页查询文章接口
     * @param page 页数
     * @param size 每次查询多少条
     * @param id 标签的id
     * @return
     */
    public IPage<Map<String, Object>> selectArticleByLimit(Integer page, Integer size, Integer id);

}
