package com.yidong.mapper;

import com.yidong.model.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(String imgaddress);

    int insert(Banner record);

    int insertSelective(Banner record);
}