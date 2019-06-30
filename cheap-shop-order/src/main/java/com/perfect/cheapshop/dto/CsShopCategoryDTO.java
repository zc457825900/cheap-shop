package com.perfect.cheapshop.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 无限级商品分类表
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
public class CsShopCategoryDTO {

    /**
     * 主键id
     */
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
    private LocalDateTime createtime;


}
