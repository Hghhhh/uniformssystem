package com.yidong.controller;

import com.alibaba.fastjson.JSONObject;
import com.yidong.config.WxPayConfig;
import com.yidong.model.User;
import com.yidong.service.UserService;
import com.yidong.util.TencentSmsSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.weixin4j.WeixinException;
import org.weixin4j.http.HttpsClient;
import org.weixin4j.http.Response;

/**
 * 登录
 * @author hgh
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 小程序后台登录，向微信平台发送获取access_token请求，并返回openId
     * @param  code, nickName，avatarUrl（小程序端获取到的）
     * @return openid
     */
    @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestParam String code,
                                      @RequestParam String nickName,
                                      @RequestParam String avatarUrl) {
        //登录用户对象
        User user = null;
        String openId = null;
        if (code == null || code.equals("")) {
            //请求错误，返回400
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
        //拼接参数
        String param = "?grant_type=" + WxPayConfig.grant_type + "&appid=" + WxPayConfig.appid + "&secret=" + WxPayConfig.secret + "&js_code=" + code;
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = null;
        JSONObject jsonObj = null;
        try {
            res = http.get("https://api.weixin.qq.com/sns/jscode2session" + param);
            jsonObj = res.asJSONObject();
            //根据请求结果判定，是否验证成功
            if (jsonObj != null) {
                Object errcode = jsonObj.get("errcode");
                if (errcode != null) {
                    //打印异常信息
                    log.error(jsonObj.get("errmsg").toString());
                    //请求错误，返回400
                    return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
                }
                else{
                    openId = jsonObj.get("openid").toString();
                    //判断用户是否已经存在
                    if((user=userService.selectByPrimaryKey(openId))!=null) {
                        userService.updateByPrimaryKey(openId,nickName,avatarUrl);
                    }
                    else{
                        //如果用户不存在，添加到数据库中
                        user = new User();
                        user.setOpenId(openId);
                        user.setPhone(null);
                        userService.insert(openId,nickName,avatarUrl);
                        log.info("new user login openid=" + openId);
                    }
                }
            }
            else{
                //连接微信接口失败504状态码
                return new ResponseEntity(null, HttpStatus.GATEWAY_TIMEOUT);
            }
        } catch (WeixinException e) {
            e.printStackTrace();
            //连接微信接口失败504状态码
            return new ResponseEntity(null, HttpStatus.GATEWAY_TIMEOUT);
        }
        user.setIntegral(userService.selectIntegral(openId));
        return new ResponseEntity(user, HttpStatus.OK);
    }

    /**
     * 获取验证码
     * @param phone
     * @return 验证码
     */
    @RequestMapping(value="/getSms")
    public String getSms(@RequestParam String phone){
        return TencentSmsSender.sendMessage(phone);
    }

    /***
     * 设置用户的手机号
     * @param openId
     * @param phone
     * @return
     */
    @RequestMapping(value = "/setPhone")
    public ResponseEntity<String> setPhone(@RequestParam String openId,@RequestParam String phone) {
       boolean flag =  userService.updatePhone(openId,phone);
       if(flag){
           return ResponseEntity.ok(phone);
       }
       else{
           return new ResponseEntity(phone,HttpStatus.BAD_REQUEST);
       }
    }
}
