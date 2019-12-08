package com.example.wx.demo.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Api(description = "用户信息类接口",value = "/api/v1")
@RequestMapping(value = "/api/v1")
@CrossOrigin
public class UserInfoController {

    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取用户信息", notes = "getUserInfo", produces = "application/json;charset=UTF-8")
    public String userInfo() {
        return "shichaoxin";
    }
}
