package com.perfect.cheapshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.perfect.cheapshop.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}