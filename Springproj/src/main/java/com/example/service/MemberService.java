package com.example.service;

import com.example.dto.MemberDTO;

public interface MemberService {

    int insertMember(MemberDTO dto);

    int checkMemberId(String userid);

    int checkMemberEmail(String email);

    String getMemberPassword(String userid);

}
