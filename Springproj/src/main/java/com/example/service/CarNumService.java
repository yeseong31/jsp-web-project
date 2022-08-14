package com.example.service;

import com.example.dto.CarNumDTO;

import java.util.List;

public interface CarNumService {

    List<CarNumDTO> getList();

    List<CarNumDTO> getList(int car_num_id);

    CarNumDTO getOne(int car_num_id);

}
