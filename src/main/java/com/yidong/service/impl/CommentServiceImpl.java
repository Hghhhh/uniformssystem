package com.yidong.service.impl;

import com.yidong.mapper.CommentMapper;
import com.yidong.model.Comment;
import com.yidong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectCommentByGoodsId(int goodsId) {
        return commentMapper.selectCommentByGoodsId(goodsId);
    }
}
