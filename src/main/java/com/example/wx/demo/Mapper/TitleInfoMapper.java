package com.example.wx.demo.Mapper;

import com.example.wx.demo.Entity.TitleNameEntity;
import com.example.wx.demo.Models.TitleInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TitleInfoMapper {
    TitleNameEntity ModelToEntity(TitleInfo titleInfo);
}
