package com.example.wx.demo.Respontory;

import com.example.wx.demo.Entity.ValueArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueArticleRepository extends JpaRepository<ValueArticleEntity, String> {
}
