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
 * 收货地址表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopAddress implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 地址id
     */
    @TableId(value = "addressid", type = IdType.AUTO)
    private Integer addressid;

    /**
     * 姓
     */
    @TableField(value = "firstname")
    private String firstname;

    /**
     * 名
     */
    @TableField(value = "lastname")
    private String lastname;

    /**
     * 公司
     */
    @TableField(value = "company")
    private String company;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 邮编
     */
    @TableField(value = "postcode")
    private String postcode;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 电话
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 用户id
     */
    @TableField(value = "userid")
    private Long userid;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private LocalDateTime createtime;


}
