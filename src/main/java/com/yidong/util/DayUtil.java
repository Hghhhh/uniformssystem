package com.yidong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 返回当前日期的字符串
 */
public class DayUtil {

    public volatile static SimpleDateFormat simpleDateFormat = null;

    public static String getDay(){
        //单例模式
        if(simpleDateFormat==null){
            synchronized(DayUtil.class){
                if(simpleDateFormat==null){
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                }
            }
        }
        return simpleDateFormat.format(new Date());
    }

}
