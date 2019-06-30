package com.perfect.cheapshop.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * <p>
 * 订单详情表
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
public class CsShopOrderDetailDTO {

    /**
     * 订单详情id
     */
    private Long detailid;

    /**
     * 订单id
     */
    private Long orderid;

    /**
     * 商品id
     */
    private Long productid;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品数量
     */
    private Integer productnum;

    /**
     * 创建时间
     */
    private Integer createtime;


}
