package com.example.service;

import com.example.dto.CarRentDTO;

public interface CarRentService {

    int insert(CarRentDTO dto);

    CarRentDTO getRentByUserid(String userid);

}
