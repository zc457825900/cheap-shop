package com.perfect.cheapshop.cheapshop.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.perfect.cheapshop.cheapshop.enums.Gender;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("cs_common_user")
public class User implements Serializable {

    @TableId(value="id",type= IdType.AUTO)
    private Long id;

    @TableField(value = "gender")
    private Gender gender;

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;

    @TableField(value = "icon")
    private String icon;

    @TableField(value = "nick_name")
    private String nickName;

    @TableField(value = "email")
    private String email;

    @TableField(value = "telphone")
    private String telphone;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value="update_time",fill =FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
