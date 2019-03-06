package com.yidong.service;

import com.yidong.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> selectCommentByGoodsId(int goodsId);

    boolean insertComment(String openId,String content,int star,int goodsId,int orderformGoodsId);

    boolean insertCommentForRandom(String openId,String content,int star,int goodsId,int orderformGoodsId);
}

