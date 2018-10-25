package com.yidong.controller;

import com.yidong.model.Comment;
import com.yidong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments")
    public List<Comment> getComments(@RequestParam  int goodsId){
        return commentService.selectCommentByGoodsId(goodsId);
    }

    @RequestMapping("/insertComments")
    public ResponseEntity<Boolean> insertComment(String openId, String content, int star, int goodsId, int orderformGoodsId){
        if(commentService.insertComment(openId,content,star,goodsId,orderformGoodsId)){
            return ResponseEntity.ok(true);
        }
        else{
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

}
