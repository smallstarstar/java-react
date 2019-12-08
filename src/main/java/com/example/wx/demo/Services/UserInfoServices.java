package com.example.wx.demo.Services;

import com.example.wx.demo.Entity.UserEnity;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoServices {
    // 用户登录
    UserEnity loginByUserNameAndUserPassword(String userName, String password);
}
