package com.example.wx.demo.Services;

import com.example.wx.demo.Entity.TitleNameEntity;
import com.example.wx.demo.Models.TitleInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TitleNameServices {
    // 保存类别名称
    Boolean saveTitleName(TitleInfo titleInfo);

    // 获取类型名称集合
    List<TitleNameEntity> getListTitleName();
}
