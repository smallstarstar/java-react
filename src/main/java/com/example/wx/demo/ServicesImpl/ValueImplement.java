package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.ArticleEntity;
import com.example.wx.demo.Entity.ValueArticleEntity;
import com.example.wx.demo.Mapper.ValueArticleInfoMapper;
import com.example.wx.demo.Models.ValueArticleInfo;
import com.example.wx.demo.Respontory.ValueArticleRepository;
import com.example.wx.demo.Services.ValueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@Component
public class ValueImplement implements ValueServices {
    @Autowired
    private ValueArticleRepository valueArticleRepository;
    @Autowired
    private ValueArticleInfoMapper valueArticleInfoMapper;

    @Override
    public Boolean valueArticleInfoByPersonIdAndArticleId(ValueArticleInfo valueArticleInfo) {
        ValueArticleEntity result = valueArticleInfoMapper.modelToEntity(valueArticleInfo);
        result.setId(UUID.randomUUID().toString());
        valueArticleRepository.save(result);
        return true;
    }
}
