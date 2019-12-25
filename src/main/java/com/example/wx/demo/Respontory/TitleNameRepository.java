package com.example.wx.demo.Respontory;

import com.example.wx.demo.Entity.TitleNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TitleNameRepository extends JpaRepository<TitleNameEntity, String> {
    @Query(value = "select c from TitleNameEntity as c where c.titleName = :titleName and c.titleType = :titleType")
    TitleNameEntity searchTypeNameByTypeName(@Param("titleName") String titleName,@Param("titleType") String titleType);
}
