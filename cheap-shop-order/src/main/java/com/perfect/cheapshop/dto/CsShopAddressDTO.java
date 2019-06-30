package com.perfect.cheapshop.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 收货地址表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CsShopAddressDTO {

    /**
     * 地址id
     */
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
    private LocalDateTime createtime;


}
