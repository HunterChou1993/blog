package com.blog.blog.controller;

import com.blog.blog.core.entity.ArticleEntity;
import com.blog.blog.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
