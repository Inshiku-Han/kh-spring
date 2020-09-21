package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.BuyListByDateVO;
import com.spring.biz.vo.BuyVO;
import com.spring.biz.vo.MemberVO;

public interface MemberService {
	//회원 가입
	int insertMember(MemberVO memberVO);
	
	//로그인
	MemberVO login(MemberVO memberVO);
	
	//중복없는 날짜 조회
	List<String> selectBuyDateList(String memberId);
	
	//날짜별 구매목록 조회
	List<BuyListByDateVO> selectBuyListByDate(BuyVO buyVO);
}




















