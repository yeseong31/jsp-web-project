package com.example.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private String userid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private Boolean is_active;
    private LocalDateTime last_login;
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;

}
