package com.spring.biz;

import com.spring.biz.vo.MemberVO;

public interface MemberService {
	//회원 가입
	int insertMember(MemberVO memberVO);
	
	//로그인
	MemberVO login(MemberVO memberVO);
}




















