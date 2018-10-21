package com.yidong.service.impl;

import com.yidong.mapper.AddressMapper;
import com.yidong.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;
    @Test
    public void updateStateByPrimaryKey() {
        addressService.updateStateByPrimaryKey("test",9);

    }
}