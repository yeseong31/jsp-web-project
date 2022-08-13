package com.example.service;

import com.example.dto.CarImageDTO;

import java.util.List;

public interface CarImageService {

    int insertImage(int car_id, String uuid, String upload_path, String filename, String type);

    List<CarImageDTO> getImageList(int car_id);

    CarImageDTO getImageOne(int car_id);

}
