package com.spring.biz.vo;

public class CartListVO extends BaseVO{
	private String cartId;
	private String fileName;
	private String goodsName;
	private String memberId;
	private String memberName;
	private String createDate;
	private int goodsPrice;
	private int goodsCnt;
	private int totalPrice;
	
	
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsCnt() {
		return goodsCnt;
	}
	public void setGoodsCnt(int goodsCnt) {
		this.goodsCnt = goodsCnt;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "CartListVO [fileName=" + fileName + ", goodsName=" + goodsName + ", memberId=" + memberId
				+ ", memberName=" + memberName + ", createDate=" + createDate + ", goodsPrice=" + goodsPrice
				+ ", goodsCnt=" + goodsCnt + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
