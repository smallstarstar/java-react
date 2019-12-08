package com.example.wx.demo.ServicesImpl;

import com.example.wx.demo.Entity.UserEnity;
import com.example.wx.demo.Respontory.UserResponsitory;
import com.example.wx.demo.Services.UserInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@Component
@Transactional
public class UserImplment implements UserInfoServices {

    @Autowired
    private UserResponsitory userResponsitory;

    @Override
    public UserEnity loginByUserNameAndUserPassword(String userName, String password) {
        return null;
    }
}
