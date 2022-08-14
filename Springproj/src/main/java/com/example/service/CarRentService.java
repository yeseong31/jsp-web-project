package com.example.service;

import com.example.dto.CarRentDTO;

import java.util.List;

public interface CarRentService {

    int insert(CarRentDTO dto);

    CarRentDTO getRentByUserid(String userid);

    List<CarRentDTO> getList();

}
