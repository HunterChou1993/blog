package com.blog.blog.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.blog.core.dao.TagDao;
import com.blog.blog.core.entity.TagEntity;
import com.blog.blog.core.service.TagService;
import org.springframework.stereotype.Service;

@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao,TagEntity> implements TagService{
}
