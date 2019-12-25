package com.example.wx.demo.Services;

import com.example.wx.demo.Models.TitleInfo;
import org.springframework.stereotype.Service;

@Service
public interface TitleNameServices {
    // 保存类别名称
    Boolean saveTitleName(TitleInfo titleInfo);
}
