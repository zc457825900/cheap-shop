package com.perfect.cheapshop.service.impl;

import com.perfect.cheapshop.domain.User;
import com.perfect.cheapshop.mapper.UserMapper;
import com.perfect.cheapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
