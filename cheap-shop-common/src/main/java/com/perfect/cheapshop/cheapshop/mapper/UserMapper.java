package com.perfect.cheapshop.cheapshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.perfect.cheapshop.cheapshop.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}