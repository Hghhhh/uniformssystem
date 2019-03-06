package com.yidong;

import com.yidong.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Iterator;
import java.util.List;

@Configuration
@EnableScheduling
public class ShceduleConfiguration {

    @Autowired
    OrderformService orderformService;

    /**
     * 每天1:00执行,查找超过七天的待收货订单，然后将其变成已完成
     */
    @Scheduled(cron = "0 0 1 ? * *")
    public void finishOrderform() {
        //得到超过七天的待收货订单id
        List<String> orderFormList = orderformService.selectWatingOrderForm();
        Iterator<String> iterator = orderFormList.iterator();
        while(iterator.hasNext()){
            //更新为已完成
            orderformService.updateOrderform(iterator.next(),null,7);
        }
    }
}
