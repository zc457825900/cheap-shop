package com.perfect.cheapshop.domain;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员详细信息表
 * </p>
 *
 * @author zhangcheng
 * @since 2019-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsShopProfile implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 真实姓名
     */
    private String truename;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 公司
     */
    private String company;

    /**
     * 用户id
     */
    private Long userid;

    /**
     * 创建时间
     */
    private Integer createtime;


}
