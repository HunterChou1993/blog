package com.blog.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tag")
public class TagEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 标签id
     */
    @TableId
    private Integer tagId;

    /**
     * 标签名字
     */
    private String tagName;
}
