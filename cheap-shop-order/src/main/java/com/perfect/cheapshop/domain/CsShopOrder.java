package com.perfect.cheapshop.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopOrder implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单id
     */
    private String orderid;

    /**
     * 下单人id
     */
    private Long userid;

    /**
     * 订单总价
     */
    private BigDecimal amount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 收货地址
     */
    private Long addressid;

    /**
     * 快递id
     */
    private Integer expressid;

    /**
     * 快递单号
     */
    private String expressno;

    /**
     * 支付交易号
     */
    private String tradeno;

    /**
     * 支付信息
     */
    private String tradeext;

    /**
     * 创建时间
     */
    private Integer createtime;

    /**
     * 更新时间
     */
    private LocalDateTime updatetime;


}
