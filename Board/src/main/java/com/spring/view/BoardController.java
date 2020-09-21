package com.spring.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.BoardService;
import com.spring.biz.vo.BoardVO;

@Controller
public class BoardController {
	@Resource(name = "boardService")
	BoardService service;
	
	//게시판 리스트
	@RequestMapping(value = "/boardList.do")
	public String selectBoardList(BoardVO boardVO, Model model) {
		System.out.println(boardVO.getSearchKeyword());
		model.addAttribute("list", service.selectBoardList(boardVO));
		return "boardList";
	}
	
	//글쓰기양식
	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.GET)
	public String boardWriteForm() {
		return "boardWriteForm";
	}
	
	//글등록
	@RequestMapping(value = "/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) {
		//쿼리실행
		service.insertBoard(boardVO);
		
		return "redirect:boardList.do"; //redirect: 컨트롤러로 재접속
	}
	
	//게시글 상세
	@RequestMapping(value = "/boardDetail.do")
	public String selectBoard(Model model,BoardVO boardVO) {
		
		model.addAttribute("board", service.selectBoard(boardVO));
		return "boardDetail";
	}
	
	
	//게시글 상세2
//	@RequestMapping(value = "/boardDetail.do")
//	public String boardWrite(@RequestParam(value = "title", defaultValue = "aaa", required = false) String bTitle, Model model) {
//		model.addAttribute("board", service.selectBoard2(bTitle));
//		return "boardDetail";
//	}
	
	//게시글 삭제
	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(String boardTitle) {
		
		service.deleteBoard(boardTitle);
		return "redirect:boardList.do";
	}
	//게시글 수정 페이지
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.GET)
	public String updateBoardForm(String boardTitle, Model model) {
		
		model.addAttribute("board", service.selectBoard2(boardTitle));
		return "updateBoardForm";
	}
	//게시글 수정 
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(BoardVO boardVO, Model model) {
		service.updateBoard(boardVO);
		model.addAttribute("boardTitle", boardVO.getBoardTitle());
// 인코딩
// String title = URLEncoder.encode(boardVO.getBoardTitle(), "UTF-8"); 이래 안하면 데이터가 한글일 때 한글깨짐
// return "redirect:boardDetail.do?title=" + title;
		return "redirect:boardDetail.do";
	}
	
}
