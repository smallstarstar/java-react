package com.example.wx.demo.Mapper;

import com.example.wx.demo.Entity.ValueArticleEntity;
import com.example.wx.demo.Models.ValueArticleInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValueArticleInfoMapper {
    ValueArticleEntity modelToEntity (ValueArticleInfo valueArticleInfo);
}
