package com.example.service;

import com.example.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCarList();

    List<CarDTO> getCarListByCarType(int car_type);

    CarDTO getCar(String id);

    int getCarIdByCode(String code);

    int insertCar(CarDTO dto);

    int updateCar(CarDTO dto);

    int deleteCar(String id);
}
