package com.example.service;

import com.example.dto.CarTypeDTO;

import java.util.List;

public interface CarTypeService {

    List<CarTypeDTO> getCarTypeList();

    CarTypeDTO getCarType(String id);

    int insertCarType(CarTypeDTO dto);

    int updateCarType(CarTypeDTO dto);

    int deleteCarType(String id);

}
