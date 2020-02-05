package com.example.wx.demo.Services;

import com.example.wx.demo.Models.ValueArticleInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ValueServices {
    // 保存收藏
    Boolean valueArticleInfoByPersonIdAndArticleId(ValueArticleInfo valueArticleInfo);

    // 获取收藏列表
}
