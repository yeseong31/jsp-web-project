package com.example.service;

import com.example.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCarList();

    List<CarDTO> getCarListByCarType(int type);

    CarDTO getCar(int id);

    int getCarIdByCode(String code);

    int insertCar(CarDTO dto);

    int updateCar(CarDTO dto);

    int deleteCar(int id);
}
