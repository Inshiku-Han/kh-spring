package com.spring.biz.vo;

public class CategoryVO extends BaseVO{
	private int categoryCode;
	private String categoryName;
	
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryVO [categoryCode=" + categoryCode + ", categoryName=" + categoryName + "]";
	}
	
}
