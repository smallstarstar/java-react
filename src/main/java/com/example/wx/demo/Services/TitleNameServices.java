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

    // 根据类别的id删除信息
    Boolean deleteTitleNameById(String id);

    // 根据类别的id编辑信息(以及特殊处理)
    TitleNameEntity upDataTitleById(String id, TitleInfo titleInfo);
}
