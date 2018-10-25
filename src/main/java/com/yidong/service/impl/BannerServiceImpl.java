package com.yidong.service.impl;

import com.yidong.mapper.BannerMapper;
import com.yidong.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public List<String> select() {
        return bannerMapper.select();
    }
}
