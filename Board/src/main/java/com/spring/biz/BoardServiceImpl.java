package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.BoardVO;

@Service("boardService") //BoardService boardService = new BoardServiceImpl();
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertBoard(BoardVO boardVO) {
		return sqlSession.insert("insertBoard", boardVO);
		
	}

	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) {
		return sqlSession.selectList("selectBoardList", boardVO);
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) {
		return sqlSession.selectOne("selectBoard", boardVO);
	}

	
	@Override
	public BoardVO selectBoard2(String boardTitle) {
		
		return sqlSession.selectOne("selectBoard2", boardTitle);
	}

	@Override
	public int deleteBoard(String boardTitle) {
		return sqlSession.delete("deleteBoard", boardTitle);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		return sqlSession.update("updateBoard", boardVO);
	}

}
