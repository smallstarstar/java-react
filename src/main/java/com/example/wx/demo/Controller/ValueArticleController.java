package com.example.wx.demo.Controller;

import com.example.wx.demo.Models.ValueArticleInfo;
import com.example.wx.demo.Services.ValueServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "收藏文章类接口")
@RequestMapping(value = "/api/v1")
@CrossOrigin
public class ValueArticleController {

    @Autowired
    private ValueServices valueServices;

    @PostMapping(value = "/saveValueArticle")
    @ApiOperation(value = "收藏文章", notes = "valueArticle", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> saveValueOfArticle(@RequestBody ValueArticleInfo valueArticleInfo) {
        Boolean  result = valueServices.valueArticleInfoByPersonIdAndArticleId(valueArticleInfo);
        HttpStatus status = result ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Boolean>(result, status);
    }
}
