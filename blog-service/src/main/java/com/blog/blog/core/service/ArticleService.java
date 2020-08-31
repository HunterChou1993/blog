package com.blog.blog.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.blog.core.entity.ArticleEntity;

import java.util.List;

/**
 * 文章相关的接口
 */
public interface ArticleService extends IService<ArticleEntity>{

    public List<ArticleEntity> selectHotArtcile();
}
