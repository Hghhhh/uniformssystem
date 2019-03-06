package com.yidong.service.impl;

import com.yidong.mapper.UserMapper;
import com.yidong.model.User;
import com.yidong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Override
    public String selectIntegral(String openId) {
       String integral = userMapper.selectIntegral(openId);
       if(integral==null || "".equals(integral)){
           integral="-1";
           return integral;
       }
       else{
           return integral;
       }
    }

    @Override
    public boolean setSchoolName(String openId, String schoolName) {
        Map map = new HashMap();
        map.put("openId",openId);
        map.put("schoolName",schoolName);
        return userMapper.setSchoolName(map)==1?true:false;
    }

    @Override
    public String selectSchoolName(String openId) {
        return userMapper.selectSchoolName(openId);
    }

    @Override
    public String selectSchoolNameForVip(String openId) {
        return userMapper.selectSchoolNameForVip(openId);
    }

    @Override
    public List<String> getUserId(){
        return userMapper.getUserId();

    }

}
