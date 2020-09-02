package com.blog.blog.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blog.core.dao.ArticleDao;
import com.blog.blog.core.entity.ArticleEntity;
import com.blog.blog.core.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("articleSevice")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao,ArticleEntity> implements ArticleService{


    @Override
    public List<ArticleEntity> selectHotArtcile() {
        List<ArticleEntity> article = this.baseMapper.selectHotArticle();
        return article;
    }

}
