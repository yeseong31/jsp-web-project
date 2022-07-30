package student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import student.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
	
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(StudentDTO dto) {
		String sql = "insert into student values(?, ?, ?)";
		Object[] values = new Object[] {dto.getId(), dto.getName(), dto.getCname()};
		int res = jdbcTemplate.update(sql, values);
		return res;
	}

	@Override
	public int deleteStudent(String id) {
		String sql = "delete from student where id = ?";
		int res = jdbcTemplate.update(sql, id);
		return res;
	}

	@Override
	public List<StudentDTO> findStudent(String name) {
		String sql = "select * from student where name = ?";
		MyRowMapper mapper = new MyRowMapper();
		List<StudentDTO> list = jdbcTemplate.query(sql, mapper, name);
		return list;
	}

	@Override
	public List<StudentDTO> listStudent() {
		String sql = "select * from student";
		MyRowMapper mapper = new MyRowMapper();
		List<StudentDTO> list = jdbcTemplate.query(sql, mapper);
		return list;
	}
	
	// 내부 클래스
	class MyRowMapper implements RowMapper<StudentDTO> {
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
