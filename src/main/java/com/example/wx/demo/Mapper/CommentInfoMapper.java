package com.example.wx.demo.Mapper;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Models.CommentInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentInfoMapper {
    CommentEntity ModelToEntity(CommentInfo commentInfo);
}
