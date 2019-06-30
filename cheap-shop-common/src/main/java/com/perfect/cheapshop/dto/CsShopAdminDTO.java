package com.perfect.cheapshop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopAdminDTO {
    private Integer adminid;

    /**
     * 管理员账号
     */
    private String adminuser;

    /**
     * 管理员密码
     */
    private String adminpass;

    /**
     * 管理员电子邮箱
     */
    private String adminemail;

    /**
     * 登陆时间
     */
    private Integer logintime;

    /**
     * 登陆IP
     */
    private Long loginip;

    /**
     * 创建时间
     */
    private Integer createtime;
}
