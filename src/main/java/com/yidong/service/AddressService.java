package com.yidong.service;

import com.yidong.model.Address;

import java.util.List;

public interface AddressService {
    boolean deleteByPrimaryKey(Integer id);

    boolean insert(Address record);

    boolean insertUserAddress(String userId,Integer id);

    List<Address> selectByPrimaryKey(String userId);

    boolean updateByPrimaryKey(Address record);

    Address selectDefaultAddress(String userId);

    Address selectByAddressId(int addressId);

    boolean updateStateByPrimaryKey(String userId,int id);
}
