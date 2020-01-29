package com.example.wx.demo.Respontory;


import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    // SQL语句
    @Query(value = "select c from UserEntity as c where c.userName = :userName and c.password = :password")
    UserEntity userLoginByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    @Query(value = "select  c from UserEntity  as c where c.id = :id")
    UserEntity getUserInfoById(@Param("id") String id);
}
