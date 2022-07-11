package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			System.out.println("오라클 드라이버가 없습니다!!");
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring07";
		pass = "spring07";
	}
	
	protected List<StudentDTO> makeList(ResultSet rs) throws SQLException {
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
	
	public List<StudentDTO> listStudent() {
		String sql = "select * from student";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("listStudent 메서드 실행 시 오류 발생!!");
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
		String sql = "insert into student values(?, ?, ?)";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCname());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertStudent 메서드 실행 시 오류 발생!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}
	
	public List<StudentDTO> findStudent(String name) {
		String sql = "select * from student where name = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("findStudent 메서드 실행 시 오류 발생!!");
		} finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
				if (rs != null) rs.close();
			} catch (SQLException ignored) {}
		}
		return null;
	}
	
	public int deleteStudent(String id) {
		String sql = "delete from student where id = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteStudent 메서드 실행 시 오류 발생!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}

}
