package board.dao;

import java.util.List;

import board.dto.BoardDTO;

public interface BoardDAO {

    // 목록 조회
    public List<BoardDTO> listBoard();

    // 데이터 조회
    public BoardDTO getBoard(int num, String mode);

    // 데이터 추가
    public int insertBoard(BoardDTO dto);

    // 데이터 삭제
    public int deleteBoard(int num, String passwd);

    // 데이터 수정
    public int updateBoard(BoardDTO dto);

}
