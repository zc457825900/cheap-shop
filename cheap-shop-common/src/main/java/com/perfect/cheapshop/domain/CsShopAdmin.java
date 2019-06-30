package com.perfect.cheapshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopAdmin implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "adminid", type = IdType.AUTO)
    private Integer adminid;

    /**
     * 管理员账号
     */
    @TableField(value = "adminuser")
    private String adminuser;

    /**
     * 管理员密码
     */
    @TableField(value = "adminpass")
    private String adminpass;

    /**
     * 管理员电子邮箱
     */
    @TableField(value = "adminemail")
    private String adminemail;

    /**
     * 登陆时间
     */
    @TableField(value = "logintime")
    private Integer logintime;

    /**
     * 登陆IP
     */
    @TableField(value = "loginip")
    private Long loginip;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private LocalDateTime createtime;


}
