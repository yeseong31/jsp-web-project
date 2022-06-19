package board.dao;

import board.dto.BoardDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

public class BoardDAOImpl implements BoardDAO {
	
	private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    private static DataSource ds;
    static {
    	try {
	        Context init = new InitialContext();
	        ds = (DataSource) init.lookup("java:comp/env/jdbc/oracle");
    	} catch(NamingException e) {
    		System.out.println("lookup 실패: " + e.getMessage());
    	}
    }
    
    protected List<BoardDTO> makeList(ResultSet rs) throws SQLException {
    	
    	List<BoardDTO> result = new ArrayList<>();
    	
    	while (rs.next()) {
    		BoardDTO dto = new BoardDTO();
    		
    		dto.setNum(rs.getInt("num"));
    		dto.setWriter(rs.getString("writer"));
    		dto.setEmail(rs.getString("email"));
    		dto.setSubject(rs.getString("subject"));
    		dto.setPasswd(rs.getString("passwd"));
    		dto.setReg_date(rs.getString("reg_date"));
    		dto.setReadCount(rs.getInt("readCount"));
    		dto.setContent(rs.getString("content"));
    		dto.setIp(rs.getString("ip"));
    		
    		result.add(dto);
    	}
    	
    	return result;
    	
    }
	
    @Override
    public List<BoardDTO> listBoard() {
        try {
        	con = ds.getConnection();
        	String sql = "select * from board order by num desc";
        	ps = con.prepareStatement(sql);
        	rs = ps.executeQuery();
        	List<BoardDTO> list = makeList(rs);
        	return list;
        } catch(SQLException e) {
        	System.out.println("listBoard() 메서드 실행 중 오류 발생!!");
        	e.printStackTrace();
        	return null;
        } finally {
        	try {
	        	if (rs != null) rs.close();
	        	if (ps != null) ps.close();
	        	if (con != null) con.close();
        	} catch (SQLException ignored) {}
        }
    }

	protected void plusReadCount(int num) throws SQLException {
		try {
			con = ds.getConnection();
			String sql = "update board set readCount = readCount + 1 where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("plusReadCount() 메서드 실행 중 오류 발생!!");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
	}

    @Override
    public BoardDTO getBoard(int num, String mode) {
		try {
			if (mode.equals("content")) {
				plusReadCount(num);
			} else if (mode.equals("update")) {

			}
			con = ds.getConnection();
			String sql = "select * from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list.get(0);
		} catch(SQLException e) {
			System.out.println("getBoard() 메서드 실행 중 오류 발생!!");
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
    }

    @Override
    public int insertBoard(BoardDTO dto) {
		try {
			con = ds.getConnection();
			String sql = "insert into board values(board_seq.nextval,?,?,?,?,sysdate,0,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getPasswd());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insertBoard() 메서드 실행 중 오류 발생!!");
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException ignored) {}
		}
	}

    @Override
    public int deleteBoard(int num, String passwd) {
        BoardDTO dto = getBoard(num, "password");
		if (dto.getPasswd().equals(passwd)) {
			try {
				con = ds.getConnection();
				String sql = "delete from board where num = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, num);
				return ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("deleteBoard() 메서드 실행 중 오류 발생!!");
				e.printStackTrace();
				return 0;
			} finally {
				try {
					if (rs != null) rs.close();
					if (ps != null) ps.close();
					if (con != null) con.close();
				} catch (SQLException ignored) {}
			}
		} else {
			return -1;
		}

    }

    @Override
    public int updateBoard(BoardDTO dto) {
		BoardDTO dbDTO = getBoard(dto.getNum(), "password");
		if (dbDTO.getPasswd().equals(dto.getPasswd())) {
			try {
				con = ds.getConnection();
				String sql = "update board set writer=?, email=?, subject=?, content=? where num=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getWriter());
				ps.setString(2, dto.getEmail());
				ps.setString(3, dto.getSubject());
				ps.setString(4, dto.getContent());
				ps.setInt(5, dto.getNum());
				return ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println("updateBoard() 메서드 실행 중 오류 발생!!");
				e.printStackTrace();
				return 0;
			} finally {
				try {
					if (rs != null) rs.close();
					if (ps != null) ps.close();
					if (con != null) con.close();
				} catch (SQLException ignored) {}
			}
		} else {
			return -1;
		}

    }
}
