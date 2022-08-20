package com.example.service;

import com.example.dto.PostDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    SqlSession session;

    @Override
    public List<PostDTO> getList(int category) {
        if (category != -1)
            return session.selectList("getPostListWithCategory", category);
        return session.selectList("getPostList");
    }

    @Override
    public int insert(PostDTO dto) {
        return session.insert("insertPost", dto);
    }

    @Override
    public PostDTO get(int id) {
        return session.selectOne("getPost", id);
    }

    @Override
    public int update(PostDTO dto) {
        return session.update("updatePost", dto);
    }

    @Override
    public int delete(int id) {
        return session.delete("deletePost", id);
    }
}
