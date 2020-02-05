package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.ArticleEntity;
import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Mapper.ArticleInfoMapper;
import com.example.wx.demo.Mapper.UserInfoMapper;
import com.example.wx.demo.Models.ArticleInfo;
import com.example.wx.demo.Models.BackArticleInfo;
import com.example.wx.demo.Respontory.ArticleRepository;
import com.example.wx.demo.Respontory.CommentRepository;
import com.example.wx.demo.Respontory.UserRepository;
import com.example.wx.demo.Services.ArticleServices;
import com.example.wx.demo.Utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public ArticleEntity saveArticleMessage(ArticleInfo articleInfo) {
        if (articleInfo.getAuthorId().equals(null)) {
            return null;
        } else {
            ArticleEntity result = articleInfoMapper.ModelToEntity(articleInfo);
            result.setId(UUID.randomUUID().toString());
            result.setLooks(0);
            result.setStars(0);
            result.setcTime(System.currentTimeMillis());
            articleRepository.save(result);
            return result;
        }
    }
    @Override
    public Boolean deleteArticleOfOwn(String id, String personId) {
        if (personId.equals(null) || personId.isEmpty()) {
            return false;
        } else {
            articleRepository.deleteById(id);
            return true;
        }
    }
    @Override
    public PageBean getArticleByPageAndSize(int page, int size) {
        PageBean pageBean = new PageBean();
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "cTime");
        Page result = articleRepository.findAll(pageable);
        pageBean.setList(result.getContent());
        List<ArticleEntity> data = result.getContent();
        List back = new ArrayList<>();
        for (ArticleEntity datum : data) {
            BackArticleInfo backArticleInfo = new BackArticleInfo();
            UserEntity userEntity =  userRepository.getUserInfoById(datum.getAuthorId());
            backArticleInfo.setUserInfo(userInfoMapper.EntityToModel(userEntity));
            // 查询品论的次数
            backArticleInfo.setCommentList(commentRepository.getArticleCommentNumberByArticleId(datum.getId()));
            backArticleInfo.setArticleEntity(datum);
            back.add(backArticleInfo);
        }
        pageBean.setList(back);
        pageBean.setTotal(result.getTotalElements());
        pageBean.setCurrentSize(result.getSize());
        pageBean.setCurrentPage(result.getTotalPages());
        return pageBean;
    }

    @Override
    public PageBean getOwnArticleByPageAndSize(String id, Integer page, Integer size) {
        PageBean pageBean = new PageBean();
        Pageable pageable = PageRequest.of(page-1, size);
        Page result = articleRepository.getOwnArticleByPersonal(id, pageable);
        pageBean.setList(result.getContent());
        pageBean.setTotal(result.getTotalElements());
        pageBean.setCurrentSize(result.getSize());
        pageBean.setCurrentPage(result.getTotalPages());
        return pageBean;
    }

    @Override
    public Boolean UpdateArticleLooksById(String id) {
        ArticleEntity result = articleRepository.getArticleEntitiesById(id);
        if(id.isEmpty() || id.equals(null)) {
            return false;
        } else {
            result.setLooks(result.getLooks() + 1 );
            articleRepository.saveAndFlush(result);
            return true;
        }
    }

    @Override
    public Boolean UpdateArticleStars(String id) {
        ArticleEntity result = articleRepository.getArticleEntitiesById(id);
        if(id.isEmpty() || id.equals(null)) {
            return false;
        } else {
            result.setStars(result.getStars() + 1);
            articleRepository.saveAndFlush(result);
            return true;
        }
    }
}
