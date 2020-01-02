package com.example.wx.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "even_info")
@Entity
public class EvenationEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "per_id")
    private String personId;

    @Column(name = "article_id")
    private String articleId;

    @Column(name = "detail_info")
    private long detailInfo;

    @Column(name = "c_time")
    private Date cTime;

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

    public long getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(long detailInfo) {
        this.detailInfo = detailInfo;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
