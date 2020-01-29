package com.example.wx.demo.Mapper;

import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserEntity ModelToEntity (UserInfo userInfo);

    UserInfo EntityToModel (UserEntity userEntity);
}
