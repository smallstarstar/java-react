package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Mapper.CommentInfoMapper;
import com.example.wx.demo.Models.CommentInfo;
import com.example.wx.demo.Respontory.CommentRepository;
import com.example.wx.demo.Services.CommentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@Component
public class CommentImplement implements CommentServices {
    @Autowired
    private CommentInfoMapper commentInfoMapper;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Boolean saveCommentInfo(CommentInfo commentInfo) {
        if(commentInfo.getPersonId().isEmpty()) {
            return false;
        } else {
            CommentEntity commentEntity = commentInfoMapper.ModelToEntity(commentInfo);
            commentEntity.setId(UUID.randomUUID().toString());
            commentEntity.setcTime(new Date());
            commentRepository.save(commentEntity);
            return true;
        }
    }
}
