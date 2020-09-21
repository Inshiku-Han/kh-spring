package com.spring.biz.vo;

public class StudentVO {
	private int stuNum;
	private String stuName;
	private int stuAge;
	private String stuAddr;
	private int classCode;
	private GradeVO gradeVO;
	
	public StudentVO() {
		super();
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuAddr() {
		return stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public GradeVO getGradeVO() {
		return gradeVO;
	}

	public void setGradeVO(GradeVO gradeVO) {
		this.gradeVO = gradeVO;
	}

	@Override
	public String toString() {
		return "StudentInfoVO [stuNum=" + stuNum + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuAddr="
				+ stuAddr + ", classCode=" + classCode + "]";
	}
	
	
}
