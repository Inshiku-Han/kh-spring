package com.spring.project.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.board.dao.BoardDAO;
import com.spring.project.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	//= @Resource(name= "boardDAO") 이름을 기준으로 객체를 넣어줌 @Service()와 페어
	@Autowired 
	private BoardDAO boardDAO;
	//자료형에 따라서 객체를 넣어줌 (applicationContext.xml에 bean이 있다)
	
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		boardDAO.deleteBoard(boardVO);
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		return boardDAO.selectBoard(boardVO);
		
	}

	@Override
	public List<BoardVO> selectBoardList() {
		return boardDAO.selectBoardList();
	}
	
}
