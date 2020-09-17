package com.spring.biz.vo;

public class BuyArrVO {
	private int[] goodsId;
	private String[] goodsName;
	private int[] orderGoodsCnt;
	private int[] orderPrice;
	private String[] cartIdArr;
	public int[] getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int[] goodsId) {
		this.goodsId = goodsId;
	}
	public String[] getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String[] goodsName) {
		this.goodsName = goodsName;
	}
	public int[] getOrderGoodsCnt() {
		return orderGoodsCnt;
	}
	public void setOrderGoodsCnt(int[] orderGoodsCnt) {
		this.orderGoodsCnt = orderGoodsCnt;
	}
	public int[] getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int[] orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String[] getCartIdArr() {
		return cartIdArr;
	}
	public void setCartIdArr(String[] cartIdArr) {
		this.cartIdArr = cartIdArr;
	}
	
}
