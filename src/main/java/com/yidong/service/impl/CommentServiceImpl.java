package com.yidong.service.impl;

import com.yidong.mapper.CommentMapper;
import com.yidong.model.Comment;
import com.yidong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectCommentByGoodsId(int goodsId) {
        return commentMapper.selectCommentByGoodsId(goodsId);
    }

    @Override
    public boolean insertComment(String openId, String content, int star, int goodsId, int orderformGoodsId) {
        Map map = new HashMap();
        map.put("openId", openId);
        map.put("content",content);
        map.put("star",star);
        map.put("goodsId",goodsId);
        map.put("orderformGoodsId",orderformGoodsId);
        return commentMapper.insertComment(map)>0?true:false;
    }
}
