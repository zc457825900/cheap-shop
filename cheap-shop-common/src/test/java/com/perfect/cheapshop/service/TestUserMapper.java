package com.perfect.cheapshop.service;

import com.perfect.cheapshop.domain.User;
import com.perfect.cheapshop.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetUser(){
       //User user = userMapper.selectById(1L);
       // User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 1));
        User user = userMapper.selectById(1L);
       Assert.assertNotNull(user);
       System.out.println(user);
    }

}
