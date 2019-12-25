package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.TitleNameEntity;
import com.example.wx.demo.Models.TitleInfo;
import com.example.wx.demo.Respontory.TitleNameRepository;
import com.example.wx.demo.Services.TitleNameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Component
@Transactional
public class TitleImplement implements TitleNameServices {

    @Autowired
    private TitleNameRepository titleNameRepository;

    @Override
    public Boolean saveTitleName(TitleInfo titleInfo) {
        // 先查询是否存在
        TitleNameEntity data = titleNameRepository.searchTypeNameByTypeName(titleInfo.getTitleName(), titleInfo.getTitleType());
        if(data != null) {
            return false;
        } else {
            TitleNameEntity titleNameEntity = new TitleNameEntity();
            titleNameEntity.setId(UUID.randomUUID().toString());
            titleNameEntity.setCreatedPerId(titleInfo.getCreatedPerId());
            titleNameEntity.setCreatedPerson(titleInfo.getCreatedPerson());
            titleNameEntity.setcTime(new Date());
            titleNameEntity.setTitleName(titleInfo.getTitleName());
            titleNameEntity.setTitleType(titleInfo.getTitleType());
            titleNameEntity.setCreatedRoleId(titleInfo.getCreatedRoleId());
            TitleNameEntity result = titleNameRepository.save(titleNameEntity);
            return true;
        }
    }

    @Override
    public List<TitleNameEntity> getListTitleName() {
        List<TitleNameEntity> result = titleNameRepository.findAll();
        return result;
    }
}
