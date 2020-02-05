package com.example.wx.demo.Respontory;

import com.example.wx.demo.Entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {
    // 根据文章的id查询文章的评论信息
    @Query(value = "select c from CommentEntity as c where c.articleId=:articleId")
    List<CommentEntity> getListOfCommentInfoByArticleId(@Param("articleId") String articleId);

    // 查看用户自己的评论信息
    @Query(value = "select c from CommentEntity as c where c.personId=:personId")
    List<CommentEntity> getListOfCommentInfoByPersonId(@Param("personId") String personId);

    // 根据文章的id获取文章评论信息
    @Query(value = "select c from CommentEntity as c where c.articleId=:articleId")
    Page getCommentInfoByArticleId(@Param("articleId") String articleId, Pageable pageable);

    // 根据文章的id获取评论的次数
    @Query(value = "select count(c.articleId) as c from CommentEntity as c where c.articleId=:articleId")
    Number getArticleCommentNumberByArticleId(@Param("articleId") String articleId);
}
