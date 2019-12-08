package com.example.wx.demo.Respontory;


import com.example.wx.demo.Entity.UserEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserResponsitory extends JpaRepository<UserEnity, String> {
    // SQL语句
    @Query(value = "select c from UserEnity as c where c.userName = :userName and c.password = :password")
    UserEnity userLoginByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
}
