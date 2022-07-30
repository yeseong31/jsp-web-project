package board.mybatis;

import board.dto.BoardDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BoardMapper {
    private static final SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "student/mybatis/Configuration.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
        }
    }

    public static List<BoardDTO> listBoard() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("listBoard");
        }
    }

    public static BoardDTO getBoard(int num, String mode) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            if (mode.equals("content")) {
                sqlSession.update("updateReadCount", num);
                sqlSession.commit();
            }
            return sqlSession.selectOne("getBoard", num);
        }
    }

    public static int insertBoard(BoardDTO dto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int res = sqlSession.update("insertBoard", dto);
            sqlSession.commit();
            return res;
        }
    }

    public static int deleteBoard(int num, String passwd) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int res = sqlSession.delete("deleteStudent", num);
            sqlSession.commit();
            return res;
        }
    }

    public static int updateBoard(BoardDTO dto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int res = -1;
            if (dto.getPasswd().equals(getBoard(dto.getNum(), "password").getPasswd())) {
                res = sqlSession.update("updateBoard", dto);
                sqlSession.commit();
            }
            return res;
        }
    }

}
