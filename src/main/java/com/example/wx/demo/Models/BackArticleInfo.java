package com.example.wx.demo.Models;

import com.example.wx.demo.Entity.ArticleEntity;
import com.example.wx.demo.Entity.UserImg;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class BackArticleInfo {
    private UserInfo personInfo;

    private UserImg userImg;

    private Number commentList;

    public Number getCommentList() {
        return commentList;
    }

    public void setCommentList(Number commentList) {
        this.commentList = commentList;
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    private ArticleEntity articleEntity;

    public UserInfo getUserInfo() {
        return personInfo;
    }

    public void setUserInfo(UserInfo personInfo) {
        this.personInfo = personInfo;
    }

    public UserImg getUserImg() {
        return userImg;
    }

    public void setUserImg(UserImg userImg) {
        this.userImg = userImg;
    }

}

