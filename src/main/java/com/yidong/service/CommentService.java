package com.yidong.service;

import com.yidong.model.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> selectCommentByGoodsId(int goodsId);
}

