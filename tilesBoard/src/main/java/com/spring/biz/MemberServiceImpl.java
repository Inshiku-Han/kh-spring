package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.BuyListByDateVO;
import com.spring.biz.vo.BuyVO;
import com.spring.biz.vo.MemberVO;

@Service("memberService") 
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertMember(MemberVO memberVO) {
		return sqlSession.insert("insertMember", memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		return sqlSession.selectOne("login", memberVO);
	}

	@Override
	public List<String> selectBuyDateList(String memberId) {
		return sqlSession.selectList("memberMapper.selectBuyDateList", memberId);
	}

	@Override
	public List<BuyListByDateVO> selectBuyListByDate(BuyVO buyVO) {
		return sqlSession.selectList("memberMapper.selectBuyListByDate", buyVO);
	}

	
}












