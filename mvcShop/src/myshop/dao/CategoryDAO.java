package myshop.dao;

import myshop.dto.CategoryDTO;

import java.util.List;

public interface CategoryDAO {
    int insertCate(CategoryDTO dto);
    List<CategoryDTO> listCate();
    int deleteCate(int cnum);
}
