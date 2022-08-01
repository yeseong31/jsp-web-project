package board.dao;

import board.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {

    // 목록 조회
    List<BoardDTO> listBoard();
    // 데이터 조회
    BoardDTO getBoard(int num, String mode);
    // 데이터 추가
    int insertBoard(BoardDTO dto);
    // 데이터 삭제
    int deleteBoard(int num, String passwd);
    // 데이터 수정
    int updateBoard(BoardDTO dto);

}
