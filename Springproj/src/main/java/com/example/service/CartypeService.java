package com.example.service;

import com.example.dto.CartypeDTO;

import java.util.List;

public interface CartypeService {

    List<CartypeDTO> getCartypeList();

    CartypeDTO getCartype(String id);

    int insertCartype(CartypeDTO dto);

    int updateCartype(CartypeDTO dto);

    int deleteCartype(String id);

}
