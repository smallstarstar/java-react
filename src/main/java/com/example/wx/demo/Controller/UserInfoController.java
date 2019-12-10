package com.example.wx.demo.Controller;
import com.example.wx.demo.Entity.UserEntity;
import com.example.wx.demo.Models.BackInfo;
import com.example.wx.demo.Services.UserInfoServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
       return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/userInfo/{page}/{size}")
    @ApiOperation(value = "用户信息分页", notes = "getUserInfoByPageAndSize", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Page<UserEntity>> getUerInfoByPageSize(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                 @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<UserEntity> result = userInfoServices.getUserInfoList(page,size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
