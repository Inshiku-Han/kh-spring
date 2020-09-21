package com.spring.biz.vo;

public class SalesVO {
	private String buyMonth;
	private int salesPerMonth;
	
	public String getBuyMonth() {
		return buyMonth;
	}
	public void setBuyMonth(String buyMonth) {
		this.buyMonth = buyMonth;
	}
	public int getSalesPerMonth() {
		return salesPerMonth;
	}
	public void setSalesPerMonth(int salesPerMonth) {
		this.salesPerMonth = salesPerMonth;
	}
	@Override
	public String toString() {
		return "SalesVO [buyMonth=" + buyMonth + ", salesPerMonth=" + salesPerMonth + "]";
	}
	
	
}