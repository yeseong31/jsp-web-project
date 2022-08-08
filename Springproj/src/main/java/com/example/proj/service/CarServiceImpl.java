package com.example.proj.service;

import com.example.proj.dto.CarDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<CarDTO> getCarList() {
        return sqlSession.selectList("getCarList");
    }

    @Override
    public CarDTO getCar(String id) {
        return sqlSession.selectOne("getCar", Integer.parseInt(id));
    }

    @Override
    public int insertCar(CarDTO dto) {
        return sqlSession.insert("insertCar", dto);
    }

    @Override
    public int updateCar(CarDTO dto) {
        int res = -1;
        // 비밀번호 일치 시 수정할 수 있도록 해야 함
        if (true) {
            res = sqlSession.update("updateCar", dto);
        }
        return res;
    }

    @Override
    public int deleteCar(String id) {
        int res = -1;
        // 비밀번호 일치 시 삭제할 수 있도록 해야 함
        if (true) {
            res = sqlSession.delete("deleteCar", Integer.parseInt(id));
        }
        return res;
    }
}