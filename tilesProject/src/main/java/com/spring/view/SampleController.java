package com.spring.view;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.biz.SampleService;

@Controller
public class SampleController {
	@Resource(name = "sampleService")
	SampleService service;
	//SampleService service = sampleService;
	
	//상단 메뉴 - 회원관리
	@RequestMapping(value = "/main.do")
	public String main() {
		return "member/main"; 
	}
	
	//상단 메뉴 - 게시판
	@RequestMapping(value = "/write.do")
	public String write() {
		return "board/write"; 
	}
	
	
	//사이드 메뉴 - 회원관리 - 회원가입
	@RequestMapping(value = "/sign.do")
	public String sign() {
		return "member/sign"; 
	}
	//사이드 메뉴 - 회원관리 - 로그인
	@RequestMapping(value = "/login.do")
	public String login() {
		return "member/login"; 
	}
	
	
	//사이드 메뉴 - 게시판 - 수정
	@RequestMapping(value = "/update.do")
	public String update() {
		return "board/update"; 
	}
	//사이드 메뉴 - 게시판 - 삭제
	@RequestMapping(value = "/delete.do")
	public String delete() {
		return "board/delete"; 
	}
	
	
	
}










