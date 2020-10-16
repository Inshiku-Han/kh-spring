package com.spring.project.board.controller;


import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.project.board.service.BoardService;
import com.spring.project.board.vo.BoardVO;

public class BoardServiceClient {
	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		BoardService service = (BoardService)container.getBean("boardService");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("제목");
		boardVO.setWriter("작성자");
		boardVO.setContent("내용");
		
		service.insertBoard(boardVO);
		List<BoardVO> list = service.selectBoardList();
		list.forEach(t -> System.out.println(t));
		
		
		
		container.close();
	}
}
