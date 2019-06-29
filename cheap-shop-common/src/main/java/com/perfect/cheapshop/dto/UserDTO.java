package com.perfect.cheapshop.dto;

import com.perfect.cheapshop.enums.Gender;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Long id;

    private Gender gender;

    private String username;

    private String password;

    private String icon;

    private String nickName;

    private String email;

    private String telphone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
