package com.blog.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class UserEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户头像
     */
    private String image;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 登录时间
     */
    private Date logintime;
}
