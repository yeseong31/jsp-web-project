package com.example.proj.service;

import com.example.proj.dto.CartypeDTO;

import java.util.List;

public interface CartypeService {

    List<CartypeDTO> getCartypeList();

    CartypeDTO getCartype(String id);

    int insertCartype(CartypeDTO dto);

    int updateCartype(CartypeDTO dto);

    int deleteCartype(String id);

}
