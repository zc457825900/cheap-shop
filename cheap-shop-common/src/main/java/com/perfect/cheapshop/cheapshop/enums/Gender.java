package com.perfect.cheapshop.cheapshop.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @classname: Gender
 * @description: 性别枚举类
 * @author zhanggcheng
 * @create 2019/6/4 10:14
 * @updateuser zhanggcheng
 * @update 2019/6/4 10:14
 * @version v1.0
 */
public enum Gender {
    MAN(1,"男"),
    WOMAN(2,"女");
    @EnumValue
    private  final int code;
    private  final String desp;
    Gender(int code,String desp){
        this.code  = code;
        this.desp = desp;
    }

    public int getCode() {
        return code;
    }

    public String getDesp() {
        return desp;
    }
}
