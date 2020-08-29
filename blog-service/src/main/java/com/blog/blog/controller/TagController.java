package com.blog.blog.controller;

import com.blog.blog.common.utils.ResultUtil;
import com.blog.blog.core.entity.TagEntity;
import com.blog.blog.core.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 获取所有标签方法
     * @return
     */
    @GetMapping("/getAllTag")
    public Map<String, Object> getAllTag(){
        Map<String, Object> data = new HashMap<>();
        try{
            //获取所有标签
            List<TagEntity> allData = tagService.list();
            int size = allData.size();
            //tagName
            //要添加一个所有标签
            String[] tagName = new String [size + 1];
            tagName[0] = "全部文章";
            for(int i=0;i<size;i++){
                tagName[i+1] = allData.get(i).getTagName();
            }
            data.put("data",tagName);
            return ResultUtil.resultSuccess(data);
        }catch (Exception e){
            data.put("msg","查询标签出错");
            return ResultUtil.resultError(data);
        }
    }
}
