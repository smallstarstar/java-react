package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Mapper.CommentInfoMapper;
import com.example.wx.demo.Models.BackArticleInfo;
import com.example.wx.demo.Models.BackCommentInfo;
import com.example.wx.demo.Models.BackInfo;
import com.example.wx.demo.Models.CommentInfo;
import com.example.wx.demo.Respontory.CommentRepository;
import com.example.wx.demo.Respontory.UserRepository;
import com.example.wx.demo.Services.CommentServices;
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

@Service
@Transactional
@Component
public class CommentImplement implements CommentServices {
    @Autowired
    private CommentInfoMapper commentInfoMapper;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean saveCommentInfo(CommentInfo commentInfo) {
        if(commentInfo.getPersonId().isEmpty()) {
            return false;
        } else {
            CommentEntity commentEntity = commentInfoMapper.ModelToEntity(commentInfo);
            commentEntity.setId(UUID.randomUUID().toString());
            commentEntity.setcTime(System.currentTimeMillis());
            commentRepository.save(commentEntity);
            return true;
        }
    }

    @Override
    public List<CommentEntity> getCommentByPersonIdAndSizeAndPage(String id) {
        List<CommentEntity> result = commentRepository.getListOfCommentInfoByPersonId(id);
        return result;
    }

    @Override
    public Boolean deleteCommentInfoByPerId(String id) {
        return null;
    }

    @Override
    public PageBean getCommentInfoByArticleId(String id, int page, int size) {
        PageBean pageBean = new PageBean();
        Pageable pageable = PageRequest.of(page-1, size, Sort.DEFAULT_DIRECTION ,"cTime");
        Page result = commentRepository.getCommentInfoByArticleId(id, pageable);
        List<CommentEntity> data = result.getContent();
        List back = new ArrayList();
        for (CommentEntity datum : data) {
            BackCommentInfo backCommentInfo = new BackCommentInfo();
            UserEntity userEntity = userRepository.getUserInfoById(datum.getPersonId());
            backCommentInfo.setUserEntity(userEntity);
            backCommentInfo.setCommentEntity(datum);
            back.add(backCommentInfo);
        }
        pageBean.setList(back);
        pageBean.setCurrentPage(result.getTotalPages());
        pageBean.setTotal(result.getTotalElements());
        pageBean.setCurrentSize(result.getSize());
        return pageBean;
    }

}
