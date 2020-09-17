package com.spring.biz.vo;

import java.util.List;

public class BuyVO extends BaseVO{
	private int orderNum;
	private String orderId;
	private String memberId;
	private String memberName;
	private int goodsId;
	private String goodsName;
	private int orderGoodsCnt;
	private int orderPrice;
	private String memberTel1;
	private String memberTel2;
	private String memberAddr;
	private String buyDate;
	private String isConfirm;
	private List<BuyVO> buyList;
	
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	public String getMemberTel1() {
		return memberTel1;
	}
	public void setMemberTel1(String memberTel1) {
		this.memberTel1 = memberTel1;
	}
	public String getMemberTel2() {
		return memberTel2;
	}
	public void setMemberTel2(String memberTel2) {
		this.memberTel2 = memberTel2;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getIsConfirm() {
		return isConfirm;
	}
	public void setIsConfirm(String isConfirm) {
		this.isConfirm = isConfirm;
	}
	public List<BuyVO> getBuyList() {
		return buyList;
	}
	public void setBuyList(List<BuyVO> buyList) {
		this.buyList = buyList;
	}
	
	@Override
	public String toString() {
		return "BuyVO [orderNum=" + orderNum + ", orderId=" + orderId + ", memberId=" + memberId + ", memberName="
				+ memberName + ", goodsId=" + goodsId + ", goodsName=" + goodsName + ", orderGoodsCnt=" + orderGoodsCnt
				+ ", orderPrice=" + orderPrice + ", memberTel1=" + memberTel1 + ", memberTel2=" + memberTel2
				+ ", memberAddr=" + memberAddr + ", buyDate=" + buyDate + ", isConfirm=" + isConfirm + ", buyList="
				+ buyList + "]";
	}
	
	
	
	
}
