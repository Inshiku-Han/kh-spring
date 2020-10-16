package com.spring.project.board.vo;


public class BoardVO {
	private int boardNum;
	private String title;
	private String writer;
	private String content;
	private String createDate;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "BoardVO [boardNum=" + boardNum + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + "]";
	}
	
}
