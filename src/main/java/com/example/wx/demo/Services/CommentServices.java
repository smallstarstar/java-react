package com.example.wx.demo.Services;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Models.CommentInfo;
import com.example.wx.demo.Utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentServices {
    // 保存评价信息
    Boolean saveCommentInfo(CommentInfo commentInfo);

    // 根据用户id获取所有用户评论文章的评论信息
    List<CommentEntity> getCommentByPersonIdAndSizeAndPage(String id);

    // 删除自己评论的信息
    Boolean deleteCommentInfoByPerId(String id);

    // 根据文章的id获取评论信息
    PageBean getCommentInfoByArticleId(String id, int page, int size);
}
