package student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	String url, user, pass;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!!");
			e.printStackTrace();
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring06";
		pass = "spring06";
	}
	
	public List<StudentDTO> listStudent() {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("listStudent 메서드 실행 중 오류 발생!!");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return null;
	}
	
	public int insertStudent(StudentDTO dto) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into student values (?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,  dto.getId());
			ps.setString(2,  dto.getName());
			ps.setString(3,  dto.getCname());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertStudent 메서드 실행 중 오류 발생!!");
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}
	
	public int deleteStudent(String id) throws SQLException {
		String sql = "delete from student where id = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			return ps.executeUpdate();
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
	}
	
	public List<StudentDTO> findStudent(String name) throws SQLException {
		String sql = "select * from student where name = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			return makeList(rs);
		} finally {
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
			if (rs != null)
				rs.close();
		}
	}
	
	public List<StudentDTO> makeList(ResultSet rs) throws SQLException {
		List<StudentDTO> list = new ArrayList<>();
		while (rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));
			list.add(dto);
		}
		return list;
	}

	
}
