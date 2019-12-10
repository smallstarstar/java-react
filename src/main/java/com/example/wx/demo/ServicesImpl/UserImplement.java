package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import com.example.wx.demo.Respontory.UserRepository;
import com.example.wx.demo.Services.UserInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Component
@Transactional
public class UserImplement implements UserInfoServices {

    private final static int LOGINSUCCESS = 1;
    private final static int USERNOTEXIZT = 2;
    private final static int MESSAGEERROR = 3;


    @Autowired
    private UserRepository userRepository;

    @Override
    public BackInfo loginByUserNameAndUserPassword(String userName, String password) {
        BackInfo backInfo = new BackInfo();
        UserEntity userEntity = userRepository.userLoginByUserNameAndPassword(userName, password);
        if (userEntity == null) {
            backInfo.setCode(USERNOTEXIZT);
            backInfo.setMessage("用户不存在，请注册");
            backInfo.setUserEntity(null);
            return backInfo;
        } else {
            backInfo.setCode(LOGINSUCCESS);
            backInfo.setMessage("登录成功");
            backInfo.setUserEntity(userEntity);
            return backInfo;
        }
    }

    @Override
    public Page getUserInfoList(int page, int size) {
        //  Sort.Direction.DESC, "roleId" 表示根据那个字段排序
        Pageable pageable = PageRequest.of(page-1, size, Sort.Direction.DESC, "roleId");
        Page result = userRepository.findAll(pageable);
        return result;
    }
}