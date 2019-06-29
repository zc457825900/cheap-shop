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
 * 商品表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopProduct implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 商品id
     */
    @TableId(value = "productid", type = IdType.AUTO)
    private Long productid;

    /**
     * 商品分类id
     */
    private Long cateid;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 库存
     */
    private Long num;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 图片集合
     */
    private String pics;

    /**
     * 是否促销
     */
    private String issale;

    /**
     * 促销价格
     */
    private BigDecimal saleprice;

    /**
     * 是否热卖
     */
    private String ishot;

    /**
     * 是否上架
     */
    private String ison;

    /**
     * 是否推荐
     */
    private String istui;

    /**
     * 创建时间
     */
    private Integer createtime;


}
