package com.example.wx.demo.Controller;
import com.example.wx.demo.Entity.UserEnity;
import com.example.wx.demo.Services.UserInfoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(description = "用户信息类接口",value = "/api/v1")
@RequestMapping(value = "/api/v1")
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoServices userInfoServices;

    @GetMapping("/login/{userName}/{password}")
    @ApiOperation(value = "用户名密码登录", notes = "getUserInfo", produces = "application/json;charset=UTF-8")
    public ResponseEntity<UserEnity> loginByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
       UserEnity result = userInfoServices.loginByUserNameAndUserPassword(userName,password);
       return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
