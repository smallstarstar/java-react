package com.example.wx.demo.Respontory;


import com.example.wx.demo.Entity.ArticleEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
    // 根据用户id分页获取用户自己发布的文章
    @Query(value = "select c from ArticleEntity  as c where c.authorId=:personId")
    Page  getOwnArticleByPersonal(@Param("personId") String personId, Pageable pageable);

    // 根据文章的id获取文章的信息
    @Query(value = "select c from ArticleEntity as c where c.id=:id")
    ArticleEntity getArticleEntitiesById(@Param("id") String id);
}
