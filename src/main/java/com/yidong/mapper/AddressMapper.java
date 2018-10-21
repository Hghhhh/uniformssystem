package com.yidong.mapper;

import java.util.List;
import java.util.Map;
import com.yidong.model.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    List<Address> selectByPrimaryKey(String userId);

    Address selectByAddressId(int addressId);

    Address selectDefaultAddress(String userId);

    int updateByPrimaryKey(Address record);

    int updateStateByPrimaryKey(Map map);

    int insertUserAddress(Map map);
}