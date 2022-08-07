package com.example.proj.service;

import com.example.proj.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCarList();

    CarDTO getCar(String id);

    int insertCar(CarDTO dto);

    int updateCar(CarDTO dto);

    int deleteCar(String id);
}
