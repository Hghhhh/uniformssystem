package com.yidong.service.impl;

import com.yidong.mapper.CommentMapper;
import com.yidong.model.Comment;
import com.yidong.service.CommentService;
import com.yidong.util.DayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    /**
     * 这个方法只是测试类用来添加随机评论的时候用的
     */
    @Override
    public boolean insertCommentForRandom(String openId, String content, int star, int goodsId, int orderformGoodsId) {
        Map map = new HashMap();
        map.put("openId", openId);
        map.put("content",content);
        map.put("star",star);
        map.put("goodsId",goodsId);
        map.put("orderformGoodsId",orderformGoodsId);
        String randDay = (Integer)((int)(Math.random()*23)+1)+"";
        if(randDay.length()<2){
            randDay = "0"+randDay;
        }
        String randMouth = (Integer)((int)(Math.random()*2)+1)+"";
        if(randMouth.length()<2){
            randMouth = "0"+randMouth;
        }
        String year = "2019";
        //随机时间
        map.put("time", year+"-"+randMouth+"-"+randDay);
       return commentMapper.insertCommentForRandom(map)>0?true:false;
    }
}
