package com.example.service;

import com.example.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getList();

    List<CommentDTO> getList(int post);

    int insert(CommentDTO dto);

    CommentDTO get(int id);

    int update(CommentDTO dto);

    int delete(int id);
}
