package com.example.proj.mapper;

import com.example.proj.dto.CartypeDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartypeMapper {

    @Autowired
    private SqlSession sqlSession;

    public List<CartypeDTO> listCartype() {
        return sqlSession.selectList("listCartype");
    }

    public CartypeDTO getCartype(String id) {
        return sqlSession.selectOne("getCartype", Integer.parseInt(id));
    }

    public int insertCartype(CartypeDTO dto) {
        return sqlSession.insert("insertCartype", dto);
    }

    public int updateCartype(CartypeDTO dto) {
        int res = -1;
        // 비밀번호 일치 시 수정할 수 있도록 해야 함
        if (true) {
            res = sqlSession.update("updateCartype", dto);
        }
        return res;
    }

    public int deleteCartype(String id) {
        int res = -1;
        // 비밀번호 일치 시 삭제할 수 있도록 해야 함
        if (true) {
            res = sqlSession.delete("deleteCartype", Integer.parseInt(id));
        }
        return res;
    }

}
