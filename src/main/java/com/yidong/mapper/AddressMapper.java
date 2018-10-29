package com.yidong.mapper;

import com.yidong.model.Address;

import java.util.List;
import java.util.Map;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    List<Address> selectByPrimaryKey(String userId);

    Address selectByAddressId(int addressId);

    Address selectDefaultAddress(String userId);

    int updateByPrimaryKey(Address record);

    int updateStateByPrimaryKey(int id);

    int insertUserAddress(Map map);

    int updateStateByUserId(String userId);
}