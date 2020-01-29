package com.example.wx.demo.Models;

import io.swagger.annotations.ApiModel;

@ApiModel
public class UserImgInfo {
    private String id;
    private String personId;
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
