package com.blog.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("article")
public class ArticleEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    @TableId
    private Integer articleId;

    /**
     * 文章题目
     */
    private String title;

    /**
     * 创建时间
     */
    private Date create_date;

    /**
     * 图片路径
     */
    private String image;


    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章浏览数
     */
    private Integer pv;
}
