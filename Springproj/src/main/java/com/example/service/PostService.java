package com.example.service;

import com.example.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getList(int category);

    int insert(PostDTO dto);

    PostDTO get(int id);

    int update(PostDTO dto);

    int delete(int id);
}
