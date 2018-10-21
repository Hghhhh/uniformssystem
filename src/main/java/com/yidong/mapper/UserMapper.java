package com.yidong.mapper;

import com.yidong.model.User;
import com.yidong.model.UserInfo;

import java.util.Map;

public interface UserMapper {

    int insert(Map<String,String> map);

    User selectByPrimaryKey(String openId);

    String selectPhone(String openId);

    String isVip(String openId);

    UserInfo selectUserInfo(String userId);

    int updateByPrimaryKey(Map<String,String> map);

    int updatePhone(Map<String,String> map);
}