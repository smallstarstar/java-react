package com.example.wx.demo.Models;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Entity.UserEntity;

public class BackCommentInfo {
  private UserEntity userEntity;
  private CommentEntity commentEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public CommentEntity getCommentEntity() {
        return commentEntity;
    }

    public void setCommentEntity(CommentEntity commentEntity) {
        this.commentEntity = commentEntity;
    }
}
