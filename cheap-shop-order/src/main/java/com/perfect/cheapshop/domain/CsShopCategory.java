package com.perfect.cheapshop.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 无限级商品分类表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopCategory implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "cateid", type = IdType.AUTO)
    private Long cateid;

    /**
     * 标题
     */
    private String title;

    /**
     * 父级id
     */
    private Long parentid;

    /**
     * 创建时间
     */
    private Integer createtime;


}
