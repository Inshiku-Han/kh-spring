package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.BoardVO;

public interface BoardService {
	//게시글 등록
	int insertBoard(BoardVO boardVO);
	//게시글 리스트 조회
	List<BoardVO> selectBoardList(BoardVO boardVO);
	//게시글 상세
	BoardVO selectBoard(BoardVO boardVO);
	//게시글 상세 2
	BoardVO selectBoard2(String boardTitle);
	//게시글 삭제
	int deleteBoard(String boardTitle);
	//게시글 수정
	int updateBoard(BoardVO boardVO);
}
