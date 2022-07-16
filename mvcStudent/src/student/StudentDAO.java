package student;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	static DataSource ds;
	static {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:/comp/env/jdbc/oracleXE");
		} catch (NamingException e) {
			e.printStackTrace();
		}
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
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("listStudent() ERROR!!");
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
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getCname());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertStudent() ERROR!!");
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
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("findStudent() ERROR!!");
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
			con = ds.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteStudent() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}

}
