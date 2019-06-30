package com.perfect.cheapshop.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员详细信息表
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
public class CsShopProfileDTO {
    
    private Long id;

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
    private LocalDateTime createtime;

}
