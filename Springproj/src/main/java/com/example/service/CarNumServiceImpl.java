package com.example.service;

import com.example.dto.CarNumDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarNumServiceImpl implements CarNumService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public List<CarNumDTO> getList() {
        return sqlSession.selectList("getList");
    }

    @Override
    public List<CarNumDTO> getList(int car) {
        return sqlSession.selectList("getListWithCarId", car);
    }

    @Override
    public CarNumDTO getOne(int car_num_id) {
        return sqlSession.selectOne("getOne", car_num_id);
    }
}
