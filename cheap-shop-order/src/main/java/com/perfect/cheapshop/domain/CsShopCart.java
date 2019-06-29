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
 * 购物车表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopCart implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 购物车id
     */
    @TableId(value = "cartid", type = IdType.AUTO)
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
    private Integer createtime;


}
