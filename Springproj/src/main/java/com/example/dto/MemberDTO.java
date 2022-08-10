package com.example.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MemberDTO {

    private String username;  // 아이디 -> Spring에서는 사용자 아이디를 username으로 인식
    private String name;      // 이름
    private String password;
    private String email;
    private Boolean is_active;
    private LocalDateTime last_login;
    private LocalDateTime reg_date;
    private LocalDateTime mod_date;

    private List<MemberAuthDTO> authList;

}
