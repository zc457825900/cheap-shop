package com.perfect.cheapshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
