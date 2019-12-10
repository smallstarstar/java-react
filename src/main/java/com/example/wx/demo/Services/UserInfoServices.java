package com.example.wx.demo.Services;

import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoServices {
    // 用户登录
    BackInfo loginByUserNameAndUserPassword(String userName, String password);
    // 分页获取用户列表
    Page getUserInfoList(int page, int size);
}
