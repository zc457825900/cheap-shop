package com.perfect.cheapshop.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "orderid", type = IdType.UUID)
    private String orderid;

    /**
     * 下单人id
     */
    @TableField(value = "userid")
    private Long userid;

    /**
     * 订单总价
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 订单状态
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 收货地址
     */
    @TableField(value = "addressid")
    private Long addressid;

    /**
     * 快递id
     */
    @TableField(value = "expressid")
    private Integer expressid;

    /**
     * 快递单号
     */
    @TableField(value = "expressno")
    private String expressno;

    /**
     * 支付交易号
     */
    @TableField(value = "tradeno")
    private String tradeno;

    /**
     * 支付信息
     */
    @TableField(value = "tradeext")
    private String tradeext;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private LocalDateTime createtime;

    /**
     * 更新时间
     */
    @TableField(value = "updatetime")
    private LocalDateTime updatetime;


}
