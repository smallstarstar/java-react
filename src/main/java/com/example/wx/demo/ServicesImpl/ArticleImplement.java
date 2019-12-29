package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.ArticleEntity;
import com.example.wx.demo.Mapper.ArticleInfoMapper;
import com.example.wx.demo.Models.ArticleInfo;
import com.example.wx.demo.Respontory.ArticleRepository;
import com.example.wx.demo.Services.ArticleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@Transactional
@Service
public class ArticleImplement implements ArticleServices {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public ArticleEntity saveArticleMessage(ArticleInfo articleInfo) {
        if(articleInfo.getAuthorId().equals(null)) {
            return null;
        } else {
            ArticleEntity result = articleInfoMapper.ModelToEntity(articleInfo);
            result.setId(UUID.randomUUID().toString());
            result.setLooks("0");
            result.setStars("0");
            result.setcTime(new Date());
            articleRepository.save(result);
            return result;
        }
    }

    @Override
    public Boolean deleteArticleOfOwn(String id, String personId) {
        if(personId.equals(null) || personId.isEmpty()) {
            return false;
        } else {
            articleRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public Page getArticleByPageAndSize(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size, Sort.Direction.DESC, "cTime");
        Page result = articleRepository.findAll(pageable);
        return result;
    }
}
