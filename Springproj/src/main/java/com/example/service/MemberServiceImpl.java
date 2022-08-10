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
    public MemberDTO read(String username) {
        return sqlSession.selectOne("read", username);
    }
}
