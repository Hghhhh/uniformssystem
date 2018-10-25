package com.yidong.controller;

import com.yidong.model.Address;
import com.yidong.service.AddressService;
import com.yidong.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/address")
    public List<Address> getAddress(@RequestParam  String openId){
        return addressService.selectByPrimaryKey(openId);
    }

    @RequestMapping(value = "/getDefaultAddress" )
    public Address getDefaultAddress(@RequestParam  String openId){
        return addressService.selectDefaultAddress(openId);
    }

    @RequestMapping(value = "/address/singleAddress")
    public Address getAddress(@RequestParam  int addressId){
        return addressService.selectByAddressId(addressId);
    }

    @RequestMapping(value = "/deleteAddress")
    public ResponseEntity delete(@RequestParam  int addressId){
        if(addressService.deleteByPrimaryKey(addressId)){
            return ResponseEntity.ok(null);
        }
        else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/addAddress")
    public ResponseEntity insertAddress(@RequestBody  String address){
        Address myAddress = JsonUtil.parseJsonWithGson(address,Address.class);
        if(addressService.insert(myAddress)&&addressService.insertUserAddress(myAddress.getOpenId(),myAddress.getId())){
            return  ResponseEntity.ok(null);
        }
        else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value="/updateStateForAddress")
    public ResponseEntity updateStateAddress(@RequestParam String openId,@RequestParam int addressId){
        if(addressService.updateStateByPrimaryKey(openId,addressId)){
            return  ResponseEntity.ok(null);
        }
        else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/updateAddress")
    public ResponseEntity updateAddress(@RequestBody String address){
        Address myAddress = JsonUtil.parseJsonWithGson(address,Address.class);
        if(addressService.updateByPrimaryKey(myAddress)){
            return ResponseEntity.ok(null);
        }
        else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }
}
