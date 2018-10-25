package com.yidong.controller;

import com.yidong.model.Orderform;
import com.yidong.service.OrderformService;
import com.yidong.util.JsonUtil;
import com.yidong.util.OrderFormId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderformController {
    @Autowired
    private OrderformService orderformService;

    @RequestMapping(value = "/insertOrderform")
    public ResponseEntity<String> insertOrderform(@RequestBody String orderform){
        Orderform myOrderform = JsonUtil.parseJsonWithGson(orderform,Orderform.class);
        String orderformId = OrderFormId.gens();
        myOrderform.setOrderformId(orderformId);
        myOrderform.setOrderformIdForOrderformGoods();
        try{
            if(orderformService.insertOrderform(myOrderform)){
                return ResponseEntity.ok(orderformId);
            }
            else{
                return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            //捕获库存不足的错误
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/getOrderformByOpenId")
    public List<Orderform> selectOrderform(@RequestParam String openId){
        return orderformService.selectOrderform(openId);
    }

    @RequestMapping("/getOrderformByOrderformId")
    public Orderform selectOrderformById(@RequestParam String orderformId){
        return orderformService.selectOrderformById(orderformId);
    }

    @RequestMapping("/updateOrderform")
    public ResponseEntity updateOrderform(@RequestParam String orderformId,Integer state,String remarksWhenRefund){
       if(orderformService.updateOrderform(orderformId,remarksWhenRefund,state)){
           return ResponseEntity.ok(null);
       }
       else{
           return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
       }
    }
}
