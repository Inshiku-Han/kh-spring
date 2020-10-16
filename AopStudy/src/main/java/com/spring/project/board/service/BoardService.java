package com.spring.project.board.service;

import java.util.List;

import com.spring.project.board.vo.BoardVO;

public interface BoardService {
	void insertBoard(BoardVO boardVO);
	void updateBoard(BoardVO boardVO);
	void deleteBoard(BoardVO boardVO);
	BoardVO selectBoard(BoardVO boardVO);
	List<BoardVO> selectBoardList();
}
