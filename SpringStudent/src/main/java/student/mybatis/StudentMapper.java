package student.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import student.dto.StudentDTO;

public class StudentMapper {
	
	private static final SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "student/mybatis/Configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException("DB 연결 오류 발생!!" + e.getMessage());
		}
	}
	
	public static List<StudentDTO> listStudent() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("listStudent");
		}
	}
	
	public static int insertStudent(StudentDTO dto) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int res = sqlSession.insert("insertStudent", dto);
			sqlSession.commit();  // 실제로 데이터가 삽입이 됨. (commit을 하지 않으면 변경 사항이 반영되지 않음)
			return res;
		}
	}
	
	public static List<StudentDTO> findStudent(String name) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("findStudent", name);
		}
	}
	
	public static int deleteStudent(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int res = sqlSession.delete("deleteStudent", id);
			sqlSession.commit();
			return res;
		}
	}

}
