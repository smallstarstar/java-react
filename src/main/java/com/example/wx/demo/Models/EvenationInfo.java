package com.example.wx.demo.Models;

import io.swagger.annotations.ApiModel;

@ApiModel
public class EvenationInfo {
    private String personId;
    private String articleId;
    private long detailInfo;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public long getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(long detailInfo) {
        this.detailInfo = detailInfo;
    }
}
