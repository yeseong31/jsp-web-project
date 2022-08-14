package com.example.service;

import com.example.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    int insertMember(MemberDTO dto);

    int insertAdmin(MemberDTO dto);

    int checkMemberId(String userid);

    int checkMemberEmail(String email);

    MemberDTO getMember(String userid);

    String getMemberPassword(String userid);

    List<MemberDTO> getMemberList();

    int updateMember(MemberDTO dto);

    MemberDTO read(String userid);

}
