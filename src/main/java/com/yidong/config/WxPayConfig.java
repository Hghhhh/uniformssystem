package com.yidong.config;

public class WxPayConfig {
    //小程序appid
    public static final String appid = "wxd611604ecd84f316";
    //微信小程序密钥
    public static final String secret = "da2df69d05e5ecf8d42b430e6a2b64b0";
    //微信支付的商户id
    public static final String mch_id = "1517064661";
    //微信支付的商户密钥
    public static final String key = "4878413d676a4bac9f6e45811081618a";

    //支付成功后的服务器回调url
    public static final String notify_url = "https://www.shashafushi.cn:8443/wxNotify";
    //签名方式
    public static final String SIGNTYPE = "MD5";
    //交易类型
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //微信统一下单接口的参数
    public static final String grant_type = "authorization_code";

    //商户证书地址
    public static final String certificate = "C:/Program Files/zapp/zapp/shashapushi.p12";

}
