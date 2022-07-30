package student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import student.dto.StudentDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(StudentDTO dto) {
		String sql = "insert into student values(?, ?, ?)";
		Object[] values = new Object[] {dto.getId(), dto.getName(), dto.getCname()};
		return jdbcTemplate.update(sql, values);
	}

	@Override
	public int deleteStudent(String id) {
		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public List<StudentDTO> findStudent(String name) {
		String sql = "select * from student where name = ?";
		MyRowMapper mapper = new MyRowMapper();
		return jdbcTemplate.query(sql, mapper, name);
	}

	@Override
	public List<StudentDTO> listStudent() {
		String sql = "select * from student";
		MyRowMapper mapper = new MyRowMapper();
		return jdbcTemplate.query(sql, mapper);
	}
	
	// 내부 클래스
	static class MyRowMapper implements RowMapper<StudentDTO> {
		@Override
		public StudentDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			return dto;
		}
	}

}
