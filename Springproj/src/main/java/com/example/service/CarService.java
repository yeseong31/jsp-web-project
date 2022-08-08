package com.example.service;

import com.example.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCarList();

    CarDTO getCar(String id);

    int insertCar(CarDTO dto);

    int updateCar(CarDTO dto);

    int deleteCar(String id);
}
