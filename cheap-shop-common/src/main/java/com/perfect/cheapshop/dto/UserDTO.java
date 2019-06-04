package com.perfect.cheapshop.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    
    private String username;
    
    private String password;
    
    private String icon;
    
    private String nickname;
    
    private String email;
    
    private String telphone;
    
    private Date creatTime;
}
