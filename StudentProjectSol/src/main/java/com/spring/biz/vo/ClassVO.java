package com.spring.biz.vo;

public class ClassVO {
	private int classCode;
	private String className;
	
	public ClassVO() {
		super();
	}
	public int getClassCode() {
		return classCode;
	}
	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "ClassInfoVO [classCode=" + classCode + ", className=" + className + "]";
	}
	
	
	
}










