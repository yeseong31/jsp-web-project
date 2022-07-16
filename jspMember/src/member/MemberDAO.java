package member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	String url, user, pass;

	private String search;
	private String searchString;

	public void setSearch(String search) {
		this.search = search;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver ERROR!!");
		}
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "spring07";
		pass = "spring07";
	}

	public boolean checkMember(String name, String ssn1, String ssn2) {
		String sql = "select * from MEMBER where ssn1=? and ssn2=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, ssn1);
			ps.setString(2, ssn2);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			System.out.println("checkMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return false;
	}

	public int insertMember(MemberDTO dto) throws SQLException {
		String sql = "insert into MEMBER values(MEMBER_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		con = DriverManager.getConnection(url, user, pass);
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPasswd());
			ps.setString(4, dto.getSsn1());
			ps.setString(5, dto.getSsn2());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getHp1());
			ps.setString(8, dto.getHp2());
			ps.setString(9, dto.getHp3());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}

	public List<MemberDTO> listMember() {
		String sql = "select * from MEMBER";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("listMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return null;
	}

	protected List<MemberDTO> makeList(ResultSet rs) throws SQLException {
		List<MemberDTO> list = new ArrayList<>();
		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setSsn1(rs.getString("ssn1"));
			dto.setSsn2(rs.getString("ssn2"));
			dto.setEmail(rs.getString("email"));
			dto.setHp1(rs.getString("hp1"));
			dto.setHp2(rs.getString("hp2"));
			dto.setHp3(rs.getString("hp3"));
			dto.setJoindate(rs.getString("joindate"));
			list.add(dto);
		}
		return list;
	}

	public int deleteMember(int no) {
		String sql = "delete from MEMBER where no = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}

	public MemberDTO getMember(int no) {
		String sql = "select * from MEMBER where no = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			return makeList(rs).get(0);
		} catch (SQLException e) {
			System.out.println("getMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return null;
	}

	public int updateMember(MemberDTO dto) {
		String sql = "update MEMBER set passwd=?, email=?, hp1=?, hp2=?, hp3=? where no = ?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPasswd());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getHp1());
			ps.setString(4, dto.getHp2());
			ps.setString(5, dto.getHp3());
			ps.setInt(6, dto.getNo());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return 0;
	}

	public List<MemberDTO> findMember() {
		String sql = "select * from MEMBER where " + search + "=?";
		try {
			con = DriverManager.getConnection(url, user, pass);
			ps = con.prepareStatement(sql);
			ps.setString(1, searchString);
			rs = ps.executeQuery();
			return makeList(rs);
		} catch (SQLException e) {
			System.out.println("findMember() ERROR!!");
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
		return null;
	}

}
