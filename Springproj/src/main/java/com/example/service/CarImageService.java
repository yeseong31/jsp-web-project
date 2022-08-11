package com.example.service;

import com.example.dto.CarImageDTO;

import java.util.List;

public interface CarImageService {

    int insertImage(String car_id, String uuid, String upload_path, String filename, String type);

    List<CarImageDTO> getImageList(String car_id);

    CarImageDTO getImageOne(String car_id);

}
