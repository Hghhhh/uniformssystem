package com.yidong.service;

import com.yidong.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hgh
 */

public interface UserService {


    boolean insert(String openId,String nickName,String avatarUrl);

    User selectByPrimaryKey(String openId);

    String selectPhone(String openId);

    String isVip(String openId);

    boolean updateByPrimaryKey(String openId,String nickName,String avatarUrl);

    boolean updatePhone(String openId,String phone);

    String selectIntegral(String openId);

    boolean setSchoolName(String openId,String schoolName);


    String selectSchoolName(String openId);


    String selectSchoolNameForVip(String openId);

    List<String> getUserId();
}
