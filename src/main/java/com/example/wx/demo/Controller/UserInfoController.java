package com.example.wx.demo.Controller;
import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import com.example.wx.demo.Models.UserInfo;
import com.example.wx.demo.Services.UserInfoServices;
import com.example.wx.demo.Utils.PageBean;
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

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @GetMapping("/login/{userName}/{password}")
    @ApiOperation(value = "用户名密码登录", notes = "getUserInfo", produces = "application/json;charset=UTF-8")
    public ResponseEntity<BackInfo> loginByUserNameAndPassword(@RequestParam String userName, @RequestParam String password) {
        BackInfo result = userInfoServices.loginByUserNameAndUserPassword(userName,password);
        HttpStatus status = result.getUserEntity() != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
       return new ResponseEntity<BackInfo>(result, status);
    }


    @PostMapping(value = "/userInfo")
    @ApiOperation(value = "新用户注册", notes = "registory", produces = "application/json;charset=UTF-8")
    public ResponseEntity<BackInfo> newUserInfoRegistory(@RequestBody UserInfo userInfo) {
        BackInfo result = userInfoServices.registoryUserInfo(userInfo);
        HttpStatus status = result != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<BackInfo>(result, status);
    }

    @PutMapping(value = "/updataUserInfo/{id}")
    @ApiOperation(value = "更新用户个人信息", notes = "upDataUserInfoMessage", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean>UpdateUserInfoMessage(@RequestParam String id, @RequestBody UserInfo userInfo) {
        Boolean result = userInfoServices.upDataUserInfo(id, userInfo);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/userInfo/{page}/{size}")
    @ApiOperation(value = "用户信息分页", notes = "getUserInfoByPageAndSize", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PageBean<UserEntity>> getUerInfoByPageSize(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                     @RequestParam(value = "size", defaultValue = "5") int size) {
        PageBean<UserEntity> result = userInfoServices.getUserInfoList(page,size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
