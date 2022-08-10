package com.example.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;

@Service
public class CarImageServiceImpl implements CarImageService {
    @Autowired
    SqlSession sqlSession;

    @Override
    public int insertImage(String car_id, String filename) {
        Map<String, String> map = new Hashtable<>();
        map.put("filename", filename);
        map.put("car_id", car_id);
        return sqlSession.insert("insertImage", map);
    }
}
