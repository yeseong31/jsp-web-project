package member.mybatis;

import member.dto.MemberDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MemberMapper {
    private static final SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "member/mybatis/Configuration.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
        }
    }

    public static List<MemberDTO> listMember() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("listMember");
        }
    }

    public static MemberDTO getMember(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("getMember", no);
        }
    }

    public static int insertMember(MemberDTO dto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int res = sqlSession.update("insertMember", dto);
            sqlSession.commit();
            return res;
        }
    }

    public static int deleteMember(int no) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int res = sqlSession.delete("deleteMember", no);
            sqlSession.commit();
            return res;
        }
    }

    public static int updateMember(MemberDTO dto) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            int res = -1;
            if (dto.getPasswd().equals(getMember(dto.getNo()).getPasswd())) {
                res = sqlSession.update("updateMember", dto);
                sqlSession.commit();
            }
            return res;
        }
    }
    public static List<MemberDTO> findMember(String search, String searchString) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Map<String, String> map = new Hashtable<>();
            map.put("search", search);
            map.put("searchString", searchString);
            return sqlSession.selectList("findMember", map);
        }
    }

    public static boolean checkMember(Map<String, String> params) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MemberDTO dto = sqlSession.selectOne("checkMember", params);
            return dto != null;
        }
    }
}
