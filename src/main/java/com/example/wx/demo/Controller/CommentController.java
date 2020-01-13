package com.example.wx.demo.Controller;

import com.example.wx.demo.Entity.CommentEntity;
import com.example.wx.demo.Models.CommentInfo;
import com.example.wx.demo.Services.CommentServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "添加品论信息")
@RequestMapping(value = "/api/v1")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentServices commentServices;

    /**
     * 保存评论信息
     * @param commentInfo
     * @return
     */
    @PostMapping(value = "/saveCommentInfo")
    @ApiOperation(value = "保存评论信息", notes = "saveCommentInfoMessage", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Boolean> saveArticleMessageInfo(@RequestBody CommentInfo commentInfo) {
        Boolean result = commentServices.saveCommentInfo(commentInfo);
        HttpStatus status = result ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<Boolean>(result, status);
    }

    @GetMapping(value = "/getCommentInfoByPerId/{id}")
    @ApiOperation(value = "根据用户id获取用户的评论信息", notes = "getCommentInfoByPerId", produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<CommentEntity>> getCommentInfoByPersonId(@RequestParam String id) {
        List<CommentEntity> result = commentServices.getCommentByPersonIdAndSizeAndPage(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
