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
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	public static List<StudentDTO> listStudent() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("listStudent");
		}
	}
	
	public static int insertStudent(StudentDTO dto) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			int res = sqlSession.update("insertStudent", dto);
			sqlSession.commit();
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
