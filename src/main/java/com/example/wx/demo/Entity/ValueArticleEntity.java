package com.example.wx.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "value_info")
@Entity
public class ValueArticleEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "per_id")
    private String personId;

    @Column(name = "ar_id")
    private String articleId;

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

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
}
