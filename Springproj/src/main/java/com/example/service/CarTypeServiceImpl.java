package com.example.service;

import com.example.dto.CarTypeDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeServiceImpl implements CarTypeService {

    @Autowired
    SqlSession sqlSession;

    public List<CarTypeDTO> getCarTypeList() {
        return sqlSession.selectList("getCarTypeList");
    }

    public CarTypeDTO getCarType(String id) {
        return sqlSession.selectOne("getCarType", Integer.parseInt(id));
    }

    public int insertCarType(CarTypeDTO dto) {
        return sqlSession.insert("insertCarType", dto);
    }

    public int updateCarType(CarTypeDTO dto) {
        int res = -1;
        // 비밀번호 일치 시 수정할 수 있도록 해야 함
        if (true) {
            res = sqlSession.update("updateCarType", dto);
        }
        return res;
    }

    public int deleteCarType(String id) {
        int res = -1;
        // 비밀번호 일치 시 삭제할 수 있도록 해야 함
        if (true) {
            res = sqlSession.delete("deleteCarType", Integer.parseInt(id));
        }
        return res;
    }

}
