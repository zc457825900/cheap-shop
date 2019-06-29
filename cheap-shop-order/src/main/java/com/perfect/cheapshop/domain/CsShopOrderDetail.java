package com.perfect.cheapshop.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
