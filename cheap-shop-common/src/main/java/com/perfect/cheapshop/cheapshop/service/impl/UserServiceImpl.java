package com.perfect.cheapshop.cheapshop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.perfect.cheapshop.cheapshop.service.UserService;
import com.perfect.cheapshop.cheapshop.domain.User;
import com.perfect.cheapshop.cheapshop.dto.UserDTO;
import com.perfect.cheapshop.cheapshop.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @classname: UserServiceImpl
 * @description: 用户服务层
 * @author zhanggcheng
 * @create 2019/6/4 10:32
 * @updateuser zhanggcheng
 * @update 2019/6/4 10:32
 * @version v1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User findUser(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<User> findAll(Map<String,Object> map) {
        return mapper.selectByMap(map);
    }

    @Override
    public IPage<User> findPage(IPage<User> page, String username, String nickname) {
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("username",nickname);
        queryWrapper.orderByAsc("id");
        return mapper.selectPage(page,queryWrapper);
    }

    @Override
    public void deleteUser(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        mapper.updateById(user);
    }

    @Override
    public User login(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        return mapper.selectOne(queryWrapper);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        mapper.insert(user);
    }
}
