package com.example.service;

import com.example.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertMember(MemberDTO dto) {
        return sqlSession.insert("insertMember", dto);
    }

    @Override
    public int checkMemberId(String userid) {
        return sqlSession.selectOne("checkMemberWithId", userid);
    }

    @Override
    public int checkMemberEmail(String email) {
        return sqlSession.selectOne("checkMemberWithEmail", email);
    }

    @Override
    public String getMemberPassword(String userid) {
        return sqlSession.selectOne("getMemberPassword", userid);
    }
}
