package com.example.wx.demo.Respontory;


import com.example.wx.demo.Entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
}
