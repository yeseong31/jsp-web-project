package board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import board.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<BoardDTO> listBoard() {
		String sql = "select * from board order by num desc";
		return jdbcTemplate.query(sql, new MyRowMapper());
	}
	
	@Override
	public BoardDTO getBoard(int num, String mode) {
		String sql = null;
		if (mode.equals("content")) {
			sql = "update board set readCount = readCount + 1 where num = ?";
			jdbcTemplate.update(sql, num);
		} 
		sql = "select * from board where num = ?";
		
		// 결과가 없을 때 나타나는 오류에 대한 대처
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] {num}, new MyRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, ?, sysdate, 0, ?, ?)";
		Object[] values = new Object[] {dto.getWriter(), dto.getEmail(), dto.getSubject(), 
										dto.getPasswd(), dto.getContent(), dto.getIp()};
		return jdbcTemplate.update(sql, values);
	}

	@Override
	public int deleteBoard(int num, String passwd) {
		BoardDTO dto = getBoard(num, "password");
		int res = -1;
		if (dto.getPasswd().equals(passwd)) {
			String sql = "delete from board where num=?";
			res = jdbcTemplate.update(sql, num);
		}
		return res;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		BoardDTO dbDTO = getBoard(dto.getNum(), "password");
		int res = -1;
		if (dbDTO.getPasswd().equals(dto.getPasswd())) {
			String sql = "update board set writer=?, email=?, subject=?, content=? where num=?";
			Object[] values = new Object[] {dto.getWriter(), dto.getEmail(), dto.getSubject(), dto.getContent(), dto.getNum()};
			res = jdbcTemplate.update(sql, values);
		}
		return res;
	}

	static class MyRowMapper implements RowMapper<BoardDTO> {
		@Override
		public BoardDTO mapRow(ResultSet rs, int arg1) throws SQLException {
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
			return dto;
		}
	}	
	
}
