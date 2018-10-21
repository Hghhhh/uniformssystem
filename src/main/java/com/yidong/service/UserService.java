package com.yidong.service;

import com.yidong.model.User;

import java.util.HashMap;
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
}
