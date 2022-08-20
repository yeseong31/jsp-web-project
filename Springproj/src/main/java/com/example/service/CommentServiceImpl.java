package com.example.service;

import com.example.dto.CommentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    SqlSession session;

    @Override
    public List<CommentDTO> getList() {
        return session.selectList("getCommentList");
    }

    @Override
    public List<CommentDTO> getList(int post) {
        return session.selectList("getCommentListWithPost", post);
    }

    @Override
    public int insert(CommentDTO dto) {
        return session.insert("insertComment", dto);
    }

    @Override
    public CommentDTO get(int id) {
        return session.selectOne("getComment", id);
    }

    @Override
    public int update(CommentDTO dto) {
        return session.update("updateComment", dto);
    }

    @Override
    public int delete(int id) {
        return session.delete("deleteComment", id);
    }
}
