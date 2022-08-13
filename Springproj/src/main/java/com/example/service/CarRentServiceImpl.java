package com.example.service;

import com.example.dto.CarRentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarRentServiceImpl implements CarRentService {

    @Autowired
    SqlSession sqlSession;

    @Override
    public int insert(CarRentDTO dto) {
        return sqlSession.insert("insert", dto);
    }

    @Override
    public CarRentDTO getRentByUserid(String userid) {
        List<CarRentDTO> list =  sqlSession.selectOne("getMemberByUserid", userid);
        if (list.size() > 0)
            return list.get(0);
        return null;
    }

}
