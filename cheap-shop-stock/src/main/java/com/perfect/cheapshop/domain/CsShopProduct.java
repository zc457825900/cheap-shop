package com.perfect.cheapshop.domain;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@TableName("cs_shop_product")
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
    @TableField(value = "cateid")
    private Long cateid;

    /**
     * 商品标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 商品描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 库存
     */
    @TableField(value = "num")
    private Long num;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 封面图
     */
    @TableField(value = "cover")
    private String cover;

    /**
     * 图片集合
     */
    @TableField(value = "pics")
    private String pics;

    /**
     * 是否促销
     */
    @TableField(value = "issale")
    private String issale;

    /**
     * 促销价格
     */
    @TableField(value = "saleprice")
    private BigDecimal saleprice;

    /**
     * 是否热卖
     */
    @TableField(value = "ishot")
    private String ishot;

    /**
     * 是否上架
     */
    @TableField(value = "ison")
    private String ison;

    /**
     * 是否推荐
     */
    @TableField(value = "istui")
    private String istui;

    /**
     * 创建时间
     */
    @TableField(value = "createtime")
    private LocalDateTime createtime;


}
