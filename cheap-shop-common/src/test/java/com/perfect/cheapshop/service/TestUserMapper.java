package com.perfect.cheapshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.perfect.cheapshop.domain.User;
import com.perfect.cheapshop.enums.Gender;
import com.perfect.cheapshop.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserMapper {
    private final static Gender DEFAULT_GENDER = Gender.MAN;
    private final static String DEFAULT_USERNAME = "小明";
    private final static String DEFAULT_PASSWORD = "123456";
    private final static String DEFAULT_ICON = "12312";
    private final static String DEFAULT_NICK_NAME = "大白";
    private final static String DEFAULT_EMAIL = "451835900@qq.com";
    private final static String DEFAULT_TELPHONE = "13253242142";
    private final static String UPDATE_USERNAME = "小强";
    private final static String UPDATE_PASSWORD = "666666";
    private final static String UPDATE_EMAIL = "123141332@qq.com";
    private final static String UPDATE_TELPHONE = "42152341234";

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUser(){
       User user = userMapper.selectById(1L);
       Assert.assertNotNull(user);
       System.out.println(user);
    }

    @Test
    @Rollback(value = true)
    public void testAddUser(){
        User user = new User();
        user.setGender(DEFAULT_GENDER);
        user.setUsername(DEFAULT_USERNAME);
        user.setPassword(DEFAULT_PASSWORD);
        user.setIcon(DEFAULT_ICON);
        user.setNickName(DEFAULT_NICK_NAME);
        user.setEmail(DEFAULT_EMAIL);
        user.setTelphone(DEFAULT_TELPHONE);
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void testDeleteUser(){
        User user = userMapper.selectById(2L);
        Assert.assertNotNull(user);
        userMapper.deleteById(2L);
        user = userMapper.selectById(2L);
        Assert.assertNull(user);
    }

    @Test
    public void testUpdateUser(){
        User user = userMapper.selectById(3L);
        Assert.assertNotNull(user);
        user.setUsername(UPDATE_USERNAME);
        user.setPassword(UPDATE_PASSWORD);
        user.setEmail(UPDATE_EMAIL);
        user.setTelphone(UPDATE_TELPHONE);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateById(user);
        Assert.assertEquals(user.getUsername(),UPDATE_USERNAME);
        Assert.assertEquals(user.getPassword(),UPDATE_PASSWORD);
        Assert.assertEquals(user.getEmail(),UPDATE_EMAIL);
        Assert.assertEquals(user.getTelphone(),UPDATE_TELPHONE);
    }

    @Test
    public void testFindUserList(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("nick_name","大白");
        List<User> list = userMapper.selectByMap(map);
        Assert.assertNotNull(list);
    }

    @Test
    public void testFindUserPage(){
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        IPage<User> page = new Page(2L,1L);
        page = userMapper.selectPage(page,queryWrapper);
        List<User> list = page.getRecords();
        Assert.assertNotNull(list);
    }
}
