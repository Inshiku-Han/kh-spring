package com.spring.project.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.project.board.vo.BoardVO;

@Component
public class BoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String BOARD_INSERT = "INSERT INTO BOARD10 (BOARD_NUM, TITLE, WRITER, CONTENT) VALUES ((SELECT NVL(MAX(BOARD_NUM) + 1, 1) FROM BOARD10), ?, ?, ?)";
	
	private final String BOARD_UPDATE = "UPDATE BOARD10 SET TITLE = ? , CONTENT = ? WHERE BOARD_NUM = ?";
	
	private final String BOARD_DELETE = "DELETE BOARD10 WHERE BOARD_NUM = ?";
	
	private final String BOARD_GET = "SELECT * FROM BOARD10 WHERE BOARD_NUM = ?";
	
	private final String BOARD_LIST = "SELECT * FROM BOARD10 ORDER BY BOARD_NUM";
	
	//게시글 등록
	public void insertBoard(BoardVO boardVO) {
		logger.info("insertBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, boardVO.getTitle());
			stmt.setString(2, boardVO.getWriter());
			stmt.setString(3, boardVO.getContent());
			stmt.executeUpdate(); //insert, update, delete
		} catch (Exception e) {
			logger.info("insertBoard 큰일났다!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//게시글시글 수정
	public void updateBoard(BoardVO boardVO) {
		logger.info("updateBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, boardVO.getTitle());
			stmt.setString(2, boardVO.getContent());
			stmt.setInt(3, boardVO.getBoardNum());
			stmt.executeUpdate();
		} catch (SQLException e) {
			logger.info("updateBoard 큰일났다!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//게시르시글 삭제
	public void deleteBoard(BoardVO boardVO) {
		logger.info("deleteBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, boardVO.getBoardNum());
			stmt.executeUpdate();
		} catch (Exception e) {
			logger.info("deleteBoard 큰일났다!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//게글시 상세 조회
	public BoardVO selectBoard(BoardVO boardVO) {
		logger.info("selectBoard() 실행");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, boardVO.getBoardNum());
			rs = stmt.executeQuery(); //select
			while(rs.next()) {
				boardVO = new BoardVO(); //초기화
				boardVO.setBoardNum(rs.getInt("BOARD_NUM"));
				boardVO.setTitle(rs.getString("TITLE"));
				boardVO.setWriter(rs.getString("WRITER"));
				boardVO.setContent(rs.getString("CONTENT"));
				boardVO.setCreateDate(rs.getString("CREATE_DATE"));
			}
		} catch (Exception e) {
			logger.info("selectBoard 큰일났다!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardVO;
	}
	
	//게글시 리스트 조회
	public List<BoardVO> selectBoardList() {
		logger.info("selectBoardList() 실행");
		
		List<BoardVO> list = new ArrayList<>();
		BoardVO vo;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery(); //select
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBoardNum(rs.getInt("BOARD_NUM"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setCreateDate(rs.getString("CREATE_DATE"));
				list.add(vo);
			}
		} catch (Exception e) {
			logger.info("selectBoardList 큰일났다!");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return list;
	}
	
	
	
}
