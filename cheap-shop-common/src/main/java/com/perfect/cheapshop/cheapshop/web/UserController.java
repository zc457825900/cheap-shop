package com.perfect.cheapshop.cheapshop.web;

import com.perfect.cheapshop.cheapshop.domain.User;
import com.perfect.cheapshop.cheapshop.exception.ResourceNotFoundException;
import com.perfect.cheapshop.cheapshop.exception.ResourceUserInfoNotCompleteException;
import com.perfect.cheapshop.cheapshop.service.UserService;
import com.perfect.cheapshop.cheapshop.dto.UserDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers(){
        List<User> users = userService.findAll(null);
        return users;
    }

     @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findUser(id);
    }

     @PutMapping
    public User updateUser(@RequestParam UserDTO userDTO) throws Exception{
        if(StringUtils.isEmpty(userDTO.getId().toString())){
            throw new Exception("Id不能为空");
        }
        userService.updateUser(userDTO);
        return userService.findUser(userDTO.getId());
    }

    @PostMapping
    public User createUser(@RequestParam UserDTO userDTO)throws Exception{
        if(!StringUtils.isEmpty( userDTO.getId().toString())){
            throw new Exception("Id不能存在");
        }
        userService.createUser(userDTO);
        return userService.findUser(userDTO.getId());
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id.toString())){
            throw new Exception("Id不能为空");
        }
        userService.deleteUser(id);
        return "删除用户成功";
    }

    @PostMapping("/login")
    @Cacheable(value="user-key")
    public User login(@RequestBody UserDTO userDTO){
        User user = null;
        if(!StringUtils.isEmpty(userDTO.getUsername())&&!StringUtils.isEmpty(userDTO.getPassword())){
            user = userService.login(userDTO);
            if(user==null) {
                throw new ResourceNotFoundException("找不到用户,请核对用户名密码");
            }
        }else{
            throw new ResourceUserInfoNotCompleteException("用户登录信息不完整");
        }
        return user;
    }

    public static void main(String[] args) {
        int arr[] ={2,3,1,0,2,5,3};
        int i=0,j=0,mark = 0;
       // for()
    }
}
