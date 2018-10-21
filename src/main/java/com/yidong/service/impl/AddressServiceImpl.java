package com.yidong.service.impl;

import com.yidong.mapper.AddressMapper;
import com.yidong.model.Address;
import com.yidong.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return addressMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insert(Address record) {
        return addressMapper.insert(record)==1;
    }

    @Override
    public boolean insertUserAddress(String userId, Integer id) {
        Map map = new HashMap();
        map.put("userId",userId);
        map.put("id",id);
        return addressMapper.insertUserAddress(map)==1?true:false;
    }

    @Override
    public List<Address> selectByPrimaryKey(String userId) {
        return addressMapper.selectByPrimaryKey(userId);
    }


    @Override
    public boolean updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record)==1;
    }

    @Override
    public Address selectDefaultAddress(String userId) {
        return addressMapper.selectDefaultAddress(userId);
    }

    @Override
    public Address selectByAddressId(int addressId) {
        return addressMapper.selectByAddressId(addressId);
    }

    @Override
    public boolean updateStateByPrimaryKey(String userId,int id) {
        Map map = new HashMap();
        map.put("id",id);
        map.put("userId",userId);
        return addressMapper.updateStateByPrimaryKey(map)>0;
    }

}
