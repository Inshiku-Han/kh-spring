package com.spring.biz.vo;

import java.util.List;

public class ImageVO {
	private String imageId;
	private int goodsId;
	private String fileName;
	private String memberId;
	private String createDate;
	private List<ImageVO> imageList;
	
	public List<ImageVO> getImageList() {
		return imageList;
	}
	public void setImageList(List<ImageVO> imageList) {
		this.imageList = imageList;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "ImageVO [imageId=" + imageId + ", goodsId=" + goodsId + ", fileName=" + fileName + ", memberId="
				+ memberId + ", createDate=" + createDate + "]";
	}
	
	
}
