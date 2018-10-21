package com.yidong.controller;

import com.yidong.model.Shoppingcar;
import com.yidong.service.ShoppingcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingcarController {

    @Autowired
    ShoppingcarService shoppingcarService;

    @RequestMapping(value="/shoppingcar")
    public List<Shoppingcar>  getShoppingcar(@RequestParam String openId){
        return shoppingcarService.selectShoppingcar(openId);
    }

    @RequestMapping(value = "/deleteShoppingcar")
    public ResponseEntity<Boolean> deleteShoppingcarGoods(@RequestParam int shoppingcarId){
        if(shoppingcarService.deleteShoppingcarGoods(shoppingcarId)){
            return  ResponseEntity.ok(true);
        }
        else{
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/updateBuyNumForShoppingcar")
    public ResponseEntity<Boolean> updateBuyNum(@RequestParam  int buyNum, @RequestParam int shoppingcarId){
        if(shoppingcarService.updateShoppingcarBuyNum(buyNum,shoppingcarId)){
            return  ResponseEntity.ok(true);
        }
        else{
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/updateStateForShoppingcar")
    public ResponseEntity<Boolean> updateState(@RequestParam int state,@RequestParam int shoppingcarId){
        if(shoppingcarService.updateShoppingcarState(state,shoppingcarId)){
            return  ResponseEntity.ok(true);
        }
        else{
            return new ResponseEntity(false, HttpStatus.BAD_REQUEST);
        }
    }

}
