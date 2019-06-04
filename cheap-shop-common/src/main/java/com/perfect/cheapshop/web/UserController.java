package com.perfect.cheapshop.web;

import com.perfect.cheapshop.domain.User;
import com.perfect.cheapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    //private UserMapper userMapper;

   /* @GetMapping
    public List<User> getUsers(){
        List<User> users = userService.findUser(1);
        return users;
    }*/

     @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.findUser(id);
    }

    /* @PutMapping
    public User updateUser(@RequestParam UserDTO userDTO) throws Exception{
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        if(StringUtils.isEmpty(user.getId())){
            throw new Exception("Id不能为空");
        }
        baseMysqlCRUDManager.updateWithNull(user);
        return user;
    }

    @PostMapping
    public User createUser(@RequestParam UserDTO userDTO)throws Exception{
        User user = new User();
        if(user!=null) {
            BeanUtils.copyProperties(userDTO, user);
        }
        if(!StringUtils.isEmpty( user.getId())){
            throw new Exception("Id不能存在");
        }
        baseMysqlCRUDManager.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id)throws Exception{
        if(!StringUtils.isEmpty(id)){
            throw new Exception("Id不能为空");
        }
        User user = new User();
        user.setId(id);
        baseMysqlCRUDManager.delete(user);
        return "删除用户成功";
    }

    @PostMapping("/login")
    @Cacheable(value="user-key")
    public User login(UserDTO userDTO){
        if(!StringUtils.isEmpty(userDTO.getUsername())&&!StringUtils.isEmpty(userDTO.getPassword())){
            String sql = "select * from cs_user where username='"+userDTO.getUsername()+"' and password='"+userDTO.getPassword()+"'";
            List<User> list = baseMysqlCRUDManager.query(sql,User.class);
            if(list.get(0)!=null) {
                return list.get(0);
            }else{
                throw new ResourceNotFoundException("找不到用户,请核对用户名密码");
            }
        }else{
            throw new ResourceUserInfoNotCompleteException("用户登录信息不完整");
        }
    }*/
}
