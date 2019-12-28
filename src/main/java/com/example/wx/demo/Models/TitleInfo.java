package com.example.wx.demo.Models;

import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel
public class TitleInfo {
    private String titleName;

    private String titleType;

    private String createdPerson;

    private String createdPerId;

    private String createdRoleId;

    private Date cTime;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getCreatedPerson() {
        return createdPerson;
    }

    public void setCreatedPerson(String createdPerson) {
        this.createdPerson = createdPerson;
    }

    public String getCreatedPerId() {
        return createdPerId;
    }

    public void setCreatedPerId(String createdPerId) {
        this.createdPerId = createdPerId;
    }

    public String getCreatedRoleId() {
        return createdRoleId;
    }

    public void setCreatedRoleId(String createdRoleId) {
        this.createdRoleId = createdRoleId;
    }

    public Date getcTime() {
        return new Date();
    }

    public void setcTime(Date cTime) {
        this.cTime = new Date();
    }
}
