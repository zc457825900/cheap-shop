package com.perfect.cheapshop.domain;

import java.math.BigDecimal;
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
 * 订单详情表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopOrderDetail implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单详情id
     */
    @TableId(value = "detailid", type = IdType.AUTO)
    private Long detailid;

    /**
     * 订单id
     */
    @TableField(value = "orderid")
    private Long orderid;

    /**
     * 商品id
     */
    @TableField(value = "productid")
    private Long productid;

    /**
     * 商品价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 商品数量
     */
    @TableField(value = "productnum")
    private Integer productnum;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private LocalDateTime createtime;


}
