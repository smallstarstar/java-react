package com.example.wx.demo.Services;


import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import com.example.wx.demo.Models.UserInfo;
import com.example.wx.demo.Utils.PageBean;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoServices {
    // 用户登录
    BackInfo loginByUserNameAndUserPassword(String userName, String password);
    // 用户注册
    BackInfo registeredUserInfo(UserInfo userInfo);
    // 修改个人信息资料
    Boolean upDataUserInfo(String id, UserInfo userInfo);
    // 分页获取用户列表
    PageBean getUserInfoList(int page, int size);
    // 获取用户的个人信息
    UserEntity getUserInfoMessage(String id);
}
