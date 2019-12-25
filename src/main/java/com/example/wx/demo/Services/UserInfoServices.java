package com.example.wx.demo.Services;

import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import com.example.wx.demo.Models.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoServices {
    // 用户登录
    BackInfo loginByUserNameAndUserPassword(String userName, String password);
    // 用户注册
    BackInfo registoryUserInfo(UserInfo userInfo);
    // 分页获取用户列表
    Page getUserInfoList(int page, int size);
}
