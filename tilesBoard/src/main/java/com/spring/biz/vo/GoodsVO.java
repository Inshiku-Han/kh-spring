package com.spring.biz.vo;

public class GoodsVO extends BaseVO{
	private int goodsId;
	private String goodsName;
	private int categoryCode;
	private String goodsWriter;
	private int goodsPrice;
	private int goodsPoint;
	private int goodsDeliveryPrice;
	private String goodsPublisher;
	private String goodsPublisherDate;
	private int goodsStatus;
	private String goodsContent;
	private String goodsCreateDate;
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
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
	public String getGoodsWriter() {
		return goodsWriter;
	}
	public void setGoodsWriter(String goodsWriter) {
		this.goodsWriter = goodsWriter;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsPoint() {
		return goodsPoint;
	}
	public void setGoodsPoint(int goodsPoint) {
		this.goodsPoint = goodsPoint;
	}
	public int getGoodsDeliveryPrice() {
		return goodsDeliveryPrice;
	}
	public void setGoodsDeliveryPrice(int goodsDeliveryPrice) {
		this.goodsDeliveryPrice = goodsDeliveryPrice;
	}
	public String getGoodsPublisher() {
		return goodsPublisher;
	}
	public void setGoodsPublisher(String goodsPublisher) {
		this.goodsPublisher = goodsPublisher;
	}
	public String getGoodsPublisherDate() {
		return goodsPublisherDate;
	}
	public void setGoodsPublisherDate(String goodsPublisherDate) {
		this.goodsPublisherDate = goodsPublisherDate;
	}
	public int getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(int goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getGoodsCreateDate() {
		return goodsCreateDate;
	}
	public void setGoodsCreateDate(String goodsCreateDate) {
		this.goodsCreateDate = goodsCreateDate;
	}
	@Override
	public String toString() {
		return "GoodsVO [goodsId=" + goodsId + ", goodsName=" + goodsName + ", categoryCode=" + categoryCode
				+ ", goodsWriter=" + goodsWriter + ", goodsPrice=" + goodsPrice + ", goodsPoint=" + goodsPoint
				+ ", goodsDeliveryPrice=" + goodsDeliveryPrice + ", goodsPublisher=" + goodsPublisher
				+ ", goodsPublisherDate=" + goodsPublisherDate + ", goodsStatus=" + goodsStatus + ", goodsContent="
				+ goodsContent + ", goodsCreateDate=" + goodsCreateDate + "]";
	}
	
	
}
