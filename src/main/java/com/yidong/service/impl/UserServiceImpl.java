package com.yidong.service.impl;

import com.yidong.mapper.UserMapper;
import com.yidong.model.User;
import com.yidong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hgh
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insert(String openId,String nickName,String avatarUrl) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("openId",openId);
        map.put("nickName",nickName);
        map.put("avatarUrl",avatarUrl);
        return userMapper.insert(map)==1?true:false;
    }

    @Override
    public User selectByPrimaryKey(String openId) {
        return userMapper.selectByPrimaryKey(openId);
    }

    @Override
    public String selectPhone(String openId) {
        return userMapper.selectPhone(openId);
    }

    @Override
    public String isVip(String openId) {
        return userMapper.isVip(openId);
    }

    @Override
    public boolean updateByPrimaryKey(String openId,String nickName,String avatarUrl) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("openId",openId);
        map.put("nickName",nickName);
        map.put("avatarUrl",avatarUrl);
        return userMapper.updateByPrimaryKey(map)==1?true:false;
    }

    @Override
    public boolean updatePhone(String openId, String phone) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("openId",openId);
        map.put("phone",phone);
        return userMapper.updatePhone(map)==1?true:false;
    }
}
