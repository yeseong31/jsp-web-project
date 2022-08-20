package com.example.service;

import com.example.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    SqlSession session;

    @Override
    public List<CategoryDTO> getList() {
        return session.selectList("getCategoryList");
    }

    @Override
    public CategoryDTO get(int id) {
        return session.selectOne("getCategory", id);
    }
}
