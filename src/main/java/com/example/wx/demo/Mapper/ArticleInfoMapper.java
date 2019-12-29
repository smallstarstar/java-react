package com.example.wx.demo.Mapper;

import com.example.wx.demo.Entity.ArticleEntity;
import com.example.wx.demo.Models.ArticleInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleInfoMapper {
    ArticleEntity ModelToEntity(ArticleInfo articleInfo);
}
