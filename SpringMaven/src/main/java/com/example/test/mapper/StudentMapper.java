package com.example.test.mapper;

import com.example.test.dto.StudentDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentMapper {

	@Autowired
	private SqlSession sqlSession;

	public List<StudentDTO> listStudent() {
		return sqlSession.selectList("listStudent");
	}

	public int insertStudent(StudentDTO dto) {
		return sqlSession.insert("insertStudent", dto);
	}

	public int deleteStudent(String id) {
		return sqlSession.delete("deleteStudent", id);
	}

	public List<StudentDTO> findStudent(String name) {
		return sqlSession.selectList("findStudent", name);
	}

}
