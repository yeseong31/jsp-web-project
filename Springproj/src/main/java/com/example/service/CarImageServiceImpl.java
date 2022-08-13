package com.example.service;

import com.example.dto.CarImageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class CarImageServiceImpl implements CarImageService {
    @Autowired
    SqlSession sqlSession;

    @Override
    public int insertImage(int car_id, String uuid, String upload_path, String filename, String type) {
        Map<String, String> map = new Hashtable<>();
        map.put("car_id", String.valueOf(car_id));
        map.put("uuid", uuid);
        map.put("upload_path", upload_path);
        map.put("filename", filename);
        map.put("type", type);
        return sqlSession.insert("insertImage", map);
    }

    @Override
    public List<CarImageDTO> getImageList(int car_id) {
        return sqlSession.selectList("getImage", car_id);
    }

    @Override
    public CarImageDTO getImageOne(int car_id) {
        // 이미지가 존재하지 않을 때 에러 발생 - 수정 필요
        return getImageList(car_id).get(0);
    }

}
