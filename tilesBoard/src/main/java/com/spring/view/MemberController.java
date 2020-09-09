package com.spring.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.biz.MemberService;
import com.spring.biz.vo.MemberVO;

@Controller
public class MemberController {
	@Resource(name = "memberService")
	MemberService memberService;
	
	//회원가입
	@RequestMapping(value = "/insertMember.me")
	public String insertMember(MemberVO memberVO) {
		memberService.insertMember(memberVO);
		return "shop/shopList"; 
	}

	//로그인
	@RequestMapping(value = "/login.me")
	public String login(MemberVO memberVO, HttpSession session) {
		MemberVO vo = memberService.login(memberVO);
		
		if(vo != null) {
			session.setAttribute("loginInfo", vo);
		}
		
		return "redirect:shopList.sh"; 
	}
	
	//로그아웃
	@RequestMapping(value = "/logout.me")
	public String logout(MemberVO memberVO, HttpSession session) {
		session.removeAttribute("loginInfo");
		return "shop/shopList"; 
	}
	
	//내 정보 조회
	@RequestMapping(value = "/selectMember.me")
	public String selectMember(MemberVO memberVO) {
		return "member/memberDetail"; 
	}
	
	//내정보 변경
	@RequestMapping(value = "/updateMember.me")
	public String updateMember(MemberVO memberVO) {
		return "member/updateMember"; 
	}
	
	//회원 탈퇴
	@RequestMapping(value = "/deleteMember.me")
	public String deleteMember(MemberVO memberVO) {
		return "member/deleteMember"; 
	}
}



















