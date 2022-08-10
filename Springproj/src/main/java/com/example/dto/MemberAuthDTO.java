package com.example.dto;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberAuthDTO {

    private String username;
    private String auth;

}
