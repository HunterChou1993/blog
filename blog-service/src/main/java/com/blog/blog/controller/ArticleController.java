package com.blog.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.blog.common.utils.ResultUtil;
import com.blog.blog.core.entity.ArticleEntity;
import com.blog.blog.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/hotArticle")
    public Map<String, Object> findHotArticle (){
        Map<String, Object> data = new HashMap<>();

        try{
           List<ArticleEntity > articleEntities = articleService.selectHotArtcile();
           data.put("data",articleEntities);
           return  data;
        }catch (Exception e){
            data.put("msg","查询失败");
            return data;
        }

    }

    /**
     * 查询文章的信息
     * @return
     */
    @GetMapping("/getArticleInfo")
    public Map<String, Object> findArticle(Integer page, Integer size,Integer id){
        //利用mybatis-plus写法
//        Map<String, Object> data = new HashMap<>();
//        //创建查询条件
//        QueryWrapper<ArticleEntity> queryWrapper = new QueryWrapper<>();
//        //如果id为0就查询全部 或者为空也查询全部
//        if( id != null && 0 != id){
//            queryWrapper.eq("tag",id);
//        }
//        //默认为文章最新创建的
//        queryWrapper.orderByDesc("create_Date");
//        Page<ArticleEntity> page1 = new Page<>(page,size);
//        IPage<Map<String, Object>> mapIPage = articleService.pageMaps(page1,queryWrapper);
//        data.put("data",mapIPage);
//        return data;
        Map<String, Object> data = new HashMap<>();
        //不用plus自带的方法写
        //如果前端传过来的页数为空就变成查询第一页防止报错
        if(page == null){
            page = 0;
        }
        //如果前端传过来的条数为空就变成查询第一页防止报错
        if(size == null){
            size = 5;
        }
        IPage<Map<String, Object>> mapIPage = articleService.selectArticleByLimit(page,size,id);
        data.put("data",mapIPage);
        return ResultUtil.resultSuccess(data);
    }
}
