package student.dao;

import java.util.List;

import student.dto.StudentDTO;

public interface StudentDAO {
	public int insertStudent(StudentDTO dto);
	public int deleteStudent(String id);
	public List<StudentDTO> findStudent(String name);
	public List<StudentDTO> listStudent();
}
