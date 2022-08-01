package com.example.test.mapper;

import com.example.test.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class MemberMapper {
    @Autowired
    private SqlSession sqlSession;

    public List<MemberDTO> listMember() {
        return sqlSession.selectList("listMember");
    }

    public MemberDTO getMember(int no) {
        return sqlSession.selectOne("getMember", no);
    }

    public int insertMember(MemberDTO dto) {
        return sqlSession.insert("insertMember", dto);
    }

    public int deleteMember(int no) {
        return sqlSession.delete("deleteMember", no);
    }

    public int updateMember(MemberDTO dto) {
        int res = -1;
        if (dto.getPasswd().equals(getMember(dto.getNo()).getPasswd()))
            res = sqlSession.update("updateMember", dto);
        return res;
    }

    public List<MemberDTO> findMember(String search, String searchString) {
        Map<String, String> map = new Hashtable<>();
        map.put("search", search);
        map.put("searchString", searchString);
        return sqlSession.selectList("findMember", map);
    }

    public boolean checkMember(Map<String, String> params) {
        MemberDTO dto = sqlSession.selectOne("checkMember", params);
        return dto != null;
    }

}
