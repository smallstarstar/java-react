package com.example.wx.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "t_name")
@Entity
public class TitleNameEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "title_name")
    private String titleName;

    @Column(name = "title_type")
    private String titleType;

    @Column(name = "c_person")
    private String createdPerson;
    @Column(name = "c_perid")
    private String createdPerId;

    @Column(name = "c_roleid")
    private String createdRoleId;

    @Column(name = "c_time")
    private Date cTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}
