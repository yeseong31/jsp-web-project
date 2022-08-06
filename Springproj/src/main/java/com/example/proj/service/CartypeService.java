package com.example.proj.service;

import com.example.proj.dto.CartypeDTO;

import java.util.List;

public interface CartypeService {

    List<CartypeDTO> listCartype();

    CartypeDTO getCartype(String id);

    int insertCartype(CartypeDTO dto);

    int updateCartype(CartypeDTO dto);

    int deleteCartype(String id);

}
