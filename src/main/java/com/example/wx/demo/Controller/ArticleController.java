package com.example.wx.demo.Controller;

import com.example.wx.demo.Entity.ArticleEntity;
import com.example.wx.demo.Models.ArticleInfo;
import com.example.wx.demo.Services.ArticleServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "文章信息接口")
@RequestMapping(value = "/api/v1")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleServices articleServices;


    @PostMapping(value = "/saveArticleInfo")
    @ApiOperation(value = "保存文章信息", notes = "saveArticleInfoMessage", produces = "application/json;charset=UTF-8")
    public ResponseEntity<ArticleEntity> saveArticleMessageInfo(@RequestBody ArticleInfo articleInfo) {
        ArticleEntity result = articleServices.saveArticleMessage(articleInfo);
        HttpStatus status = result != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<ArticleEntity>(result, status);
    }

    @DeleteMapping(value = "/deleteArtice/{id}/{personId}")
    @ApiOperation(value = "删除文章", notes = "deleteArticle", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> deleteArticleOfOwn(@RequestParam String id, @RequestParam String personId) {
        Boolean result = articleServices.deleteArticleOfOwn(id, personId);
        HttpStatus status = result ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Boolean>(result, status);
    }

    @GetMapping("/articleInfo/{page}/{size}")
    @ApiOperation(value = "文章分页获取", notes = "getArticleInfoByPageAndSize", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Page<ArticleEntity>> getUerInfoByPageSize(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                 @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<ArticleEntity> result = articleServices.getArticleByPageAndSize(page,size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
