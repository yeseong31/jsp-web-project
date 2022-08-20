package com.example.service;

import com.example.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getList();

    CategoryDTO get(int id);
}
