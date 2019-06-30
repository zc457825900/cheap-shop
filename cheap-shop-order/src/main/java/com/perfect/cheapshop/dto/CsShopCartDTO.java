package com.perfect.cheapshop.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 购物车表
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
public class CsShopCartDTO {

    /**
     * 购物车id
     */
    private Long cartid;

    /**
     * 商品id
     */
    private Long productid;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 加入购物车的商品数量
     */
    private Integer productnum;

    /**
     * 加入购物车时的商品价格
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


}
