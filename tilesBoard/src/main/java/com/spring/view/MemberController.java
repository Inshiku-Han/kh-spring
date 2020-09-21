package com.spring.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.MemberService;
import com.spring.biz.vo.BuyListByDateVO;
import com.spring.biz.vo.BuyVO;
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
	
	
	//구매목록 조회
	@RequestMapping(value = "/selectBuyList.me")
	public String selectBuyList(MemberVO memberVO, HttpSession session, Model model) {
		
		//모든 데이터를 담고 있는 객체 생성(내림차순 정렬)
		Map<String, List<BuyListByDateVO>> map = new TreeMap<>(Collections.reverseOrder());
				
		//구매일자별 총 구매금액 정보를 담을 리스트
		List<Integer> orderPricePerDate = new ArrayList<>();
		
		//세션에서 아이디 소환
		MemberVO sessionMember = ((MemberVO)session.getAttribute("loginInfo"));
		String memberId = sessionMember.getMemberId();
		
		//중복제거된 날짜를 담을 수 있는 리스트
		List<String> buyDateList = memberService.selectBuyDateList(memberId);
		
		//구매일자 수만큼 반복해서 해당 구매일의 구매목록을 조회
		for(String e : buyDateList) {
			BuyVO buyVO = new BuyVO();
			buyVO.setBuyDate(e);
			buyVO.setMemberId(memberId);
			List<BuyListByDateVO> buyListByDate =  memberService.selectBuyListByDate(buyVO);
			map.put(e,buyListByDate);
			
			//구매날짜별 총 구매금액을 저장할 변수
			int totalPricePerDate = 0;
			for(BuyListByDateVO vo : buyListByDate) {
				totalPricePerDate += vo.getOrderPrice();
			}
			orderPricePerDate.add(totalPricePerDate);
		}
		
		model.addAttribute("buyList", map);
		model.addAttribute("orderPricePerDate", orderPricePerDate);
		
		return "member/selectBuyList"; 
	}
	
	
}



















