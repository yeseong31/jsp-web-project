package com.example.test.model;

import com.example.test.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardMapper {

    @Autowired
    private SqlSession sqlSession;

    public List<BoardDTO> listBoard() {
        return sqlSession.selectList("listBoard");
    }

    public BoardDTO getBoard(int num, String mode) {
        if (mode.equals("content"))
            sqlSession.update("updateReadCount", num);
        return sqlSession.selectOne("getBoard", num);
    }

    public int insertBoard(BoardDTO dto) {
        return sqlSession.insert("insertBoard", dto);
    }

    public int deleteBoard(int num, String passwd) {
        BoardDTO dto = getBoard(num, "password");
        int res = -1;
        if (dto.getPasswd().equals(passwd))
            res = sqlSession.delete("deleteBoard", num);
        return res;
    }

    public int updateBoard(BoardDTO dto) {
        BoardDTO tmpBoard = getBoard(dto.getNum(), "password");
        int res = -1;
        if (tmpBoard.getPasswd().equals(dto.getPasswd()))
            res = sqlSession.update("updateBoard", dto);
        return res;
    }

}
