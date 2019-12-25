package com.example.wx.demo.Controller;

import com.example.wx.demo.Models.TitleInfo;
import com.example.wx.demo.Services.TitleNameServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "标题名称")
@RequestMapping(value = "/api/v1")
public class TitleNameController {
    @Autowired
    private TitleNameServices titleNameServices;

    // 保存标题名称
    @PostMapping(value = "/saveTitleName")
    @ApiOperation(value = "字典表保存标题信息", notes = "saveTitleName", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> saveTitleNameInfo(@RequestBody TitleInfo titleInfo) {
        Boolean result = titleNameServices.saveTitleName(titleInfo);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
