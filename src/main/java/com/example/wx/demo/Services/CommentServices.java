package com.example.wx.demo.Services;

import com.example.wx.demo.Models.CommentInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentServices {
    // 保存评价信息
    Boolean saveCommentInfo(CommentInfo commentInfo);

    // 获取评论信息
}
