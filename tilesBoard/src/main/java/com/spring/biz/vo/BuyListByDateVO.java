package com.spring.biz.vo;

public class BuyListByDateVO extends BaseVO {
	private int orderNum;
	private String goodsName;
	private String fileName;
	private int goodsPrice;
	private int orderGoodsCnt;
	private int orderPrice;
	
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getOrderGoodsCnt() {
		return orderGoodsCnt;
	}
	public void setOrderGoodsCnt(int orderGoodsCnt) {
		this.orderGoodsCnt = orderGoodsCnt;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	@Override
	public String toString() {
		return "BuyListByDateVO [orderNum=" + orderNum + ", goodsName=" + goodsName + ", fileName=" + fileName
				+ ", goodsPrice=" + goodsPrice + ", orderGoodsCnt=" + orderGoodsCnt + ", orderPrice=" + orderPrice
				+ "]";
	}
	

	
}
