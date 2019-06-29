package com.perfect.cheapshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
    private String firstname;

    /**
     * 名
     */
    private String lastname;

    /**
     * 公司
     */
    private String company;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 创建时间
     */
    private Integer createtime;


}
