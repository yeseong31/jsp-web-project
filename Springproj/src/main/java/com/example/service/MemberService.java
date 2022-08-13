package com.example.service;

import com.example.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    int insertMember(MemberDTO dto);

    int checkMemberId(String userid);

    int checkMemberEmail(String email);

    String getMemberPassword(String userid);

    List<MemberDTO> getMemberList();

    MemberDTO read(String userid);

}
