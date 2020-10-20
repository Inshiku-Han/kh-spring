package com.spring.project.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.board.dao.BoardDAO;
import com.spring.project.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	//@Resource(name= "boardDAO") 이름을 기준으로 객체를 넣어줌 @Service()와 페어
	@Autowired 
	private BoardDAO boardDAO;
	//자료형에 따라서 객체를 넣어줌 (applicationContext.xml에 bean이 있다)
	
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		System.out.println("insertBoard() 실행");
		boardDAO.insertBoard(boardVO);
		System.out.println("insertBoard() 끝");
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		System.out.println("updateBoard() 실행");
		boardDAO.updateBoard(boardVO);
		System.out.println("updateBoard() 끝");
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		System.out.println("deleteBoard() 실행");
		boardDAO.deleteBoard(boardVO);
		System.out.println("deleteBoard() 끝");
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		System.out.println("selectBoard() 실행");
		return boardDAO.selectBoard(boardVO);
		
	}

	@Override
	public List<BoardVO> selectBoardList() {
		System.out.println("selectBoardList() 실행");
		return boardDAO.selectBoardList();
	}
	
}
