package com.yidong.mapper;

import com.yidong.model.Comment;

import java.util.List;
import java.util.Map;
public interface CommentMapper {
    List<Comment> selectCommentByGoodsId(int goodsId);

    int insertComment(Map map);


   int insertCommentForRandom(Map map);
}