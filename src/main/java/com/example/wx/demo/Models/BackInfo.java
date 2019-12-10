package com.example.wx.demo.Models;

import com.example.wx.demo.Entity.UserEntity;
import io.swagger.annotations.ApiModel;

@ApiModel
public class BackInfo {
   private int code;
   private String message;
   private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
