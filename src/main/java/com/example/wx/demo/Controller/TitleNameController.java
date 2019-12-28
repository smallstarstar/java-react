package com.example.wx.demo.Controller;

import com.example.wx.demo.Entity.TitleNameEntity;
import com.example.wx.demo.Models.TitleInfo;
import com.example.wx.demo.Services.TitleNameServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Api(description = "标题名称")
@RequestMapping(value = "/api/v1")
public class TitleNameController {
    @Autowired
    private TitleNameServices titleNameServices;

    /**
     * 字典表保存标题信息
     * @param titleInfo
     * @return
     */
    @PostMapping(value = "/saveTitleName")
    @ApiOperation(value = "字典表保存标题信息", notes = "saveTitleName", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> saveTitleNameInfo(@RequestBody TitleInfo titleInfo) {
        Boolean result = titleNameServices.saveTitleName(titleInfo);
        HttpStatus status = result ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Boolean>(result, status);
    }


    @GetMapping(value = "/listTypeName")
    @ApiOperation(value = "获取字典表标题信息", notes = "getListTypeName", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<TitleNameEntity>> getListTypeNames() {
        List<TitleNameEntity> result = titleNameServices.getListTitleName();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping(value = "/deleteTitleNameById/{id}")
    @ApiOperation(value = "根据类别名称删除信息",notes = "deleteTitleName", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> deleteTitleNameById(@RequestParam String id) {
        Boolean result = titleNameServices.deleteTitleNameById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping(value = "/upDataTitleInfo/{id}")
    @ApiOperation(value = "更新标题名称",notes = "updataTitleInfoMessage", produces = "application/json;charset=UTF-8")
    public ResponseEntity<TitleNameEntity> upDataTitleNameInfo(@RequestParam String id, @RequestBody TitleInfo titleInfo) {
        TitleNameEntity result = titleNameServices.upDataTitleById(id, titleInfo);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
