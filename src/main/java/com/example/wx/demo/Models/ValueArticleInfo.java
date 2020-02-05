package com.example.wx.demo.Models;

import io.swagger.annotations.ApiModel;

@ApiModel
public class ValueArticleInfo {
    private String personId;

    private String articleId;

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
}
