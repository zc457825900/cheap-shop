package com.perfect.cheapshop.cheapshop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.perfect.cheapshop.cheapshop.domain.User;
import com.perfect.cheapshop.cheapshop.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User findUser(Long id);
    public List<User> findAll(Map<String,Object> map);
    public IPage<User> findPage(IPage<User> page,String username,String nickname);
    public void deleteUser(Long id);
    public void updateUser(UserDTO user);
    public User login(UserDTO user);
    public void createUser(UserDTO user);
}
