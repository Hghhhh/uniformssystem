package com.yidong.mapper;

import com.yidong.model.User;

import java.util.Map;

public interface UserMapper {

    int insert(Map<String,String> map);

    User selectByPrimaryKey(String openId);

    String selectPhone(String openId);

    String isVip(String openId);

    int updateByPrimaryKey(Map<String,String> map);
}