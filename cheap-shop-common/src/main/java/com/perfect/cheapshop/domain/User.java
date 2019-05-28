package com.perfect.cheapshop.domain;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.perfect.cheapshop.enums.Gender;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="cs_user")
public class User extends BaseModel implements Serializable {
    private static final long serialVersionUID = 5199200306752426433L;
    @Column(name="id",type= MySqlTypeConstant.BIGINT,length=11,isKey = true,isAutoIncrement = true)
    private Long id;
    @Column(name="gender",type=MySqlTypeConstant.INT)
    private Gender gender;
    @Column(name="username",type=MySqlTypeConstant.VARCHAR)
    private String username;
    @Column(name="password",type=MySqlTypeConstant.VARCHAR)
    private String password;
    @Column(name="icon",type=MySqlTypeConstant.VARCHAR)
    private String icon;
    @Column(name="nick_name",type=MySqlTypeConstant.VARCHAR)
    private String nickName;
    @Column(name="email",type=MySqlTypeConstant.VARCHAR)
    private String email;
    @Column(name="telphone",type=MySqlTypeConstant.VARCHAR)
    private String telphone;
    @Column(name="create_time",type=MySqlTypeConstant.DATETIME)
    private Date creatTime;
}
