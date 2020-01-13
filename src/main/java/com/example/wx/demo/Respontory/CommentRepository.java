package com.example.wx.demo.Respontory;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Utils.PageBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, String> {
//    select * from table limit (start-1)*limit,limit; 其中start是页码，limit是每页显示的条数。
//    select c from CommentEntity as c where c.personId=:personId order by (start - 1)*limit,limit
    // 根据文章的id查询文章的评论信息
    @Query(value = "select c from CommentEntity as c where c.articleId=:articleId")
    List<CommentEntity> getListOfCommentInfoByArticleId(@Param("articleId") String articleId);

    // 查看用户自己的评论信息
    @Query(value = "select c from CommentEntity as c where c.personId=:personId")
    List<CommentEntity> getListOfCommentInfoByPersonId(@Param("personId") String personId);

    // 根据文章的id获取文章评论信息
    @Query(value = "select c from CommentEntity as c where c.articleId=:articleId")
    PageBean<CommentEntity> getCommentInfoByArticleId(@Param("articleId") String articleId);
}
