package com.spring.biz.vo;

public class GradeVO {
	private int gradeCode;
	private int stuNum;
	private int korScore;
	private int mathScore;
	private int engScore;
	
	public GradeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	@Override
	public String toString() {
		return "GradeInfoVO [gradeCode=" + gradeCode + ", stuNum=" + stuNum + ", korScore=" + korScore + ", mathScore="
				+ mathScore + ", engScore=" + engScore + "]";
	}
	
	
}
