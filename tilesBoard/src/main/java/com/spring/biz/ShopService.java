package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.BuyVO;
import com.spring.biz.vo.CartListVO;
import com.spring.biz.vo.CartVO;
import com.spring.biz.vo.CategoryVO;
import com.spring.biz.vo.GoodsVO;
import com.spring.biz.vo.ImageVO;
import com.spring.biz.vo.SalesVO;
import com.spring.biz.vo.SearchVO;

public interface ShopService {
	//상품 카테고리 리스트 조회
	List<CategoryVO> selectCategoryList();
	
	//상품등록
	void insertGoods(GoodsVO goodsVO, ImageVO imageVO);
	
	//상품 첨부파일 이미지 등록
	int insertImage(ImageVO imageVO);
	
	//상품ID 조회
	int getMaxId();
	
	//상품 목록 조회
	List<GoodsVO> selectGoodsList(GoodsVO goodsVO);
	
	//상품상세 조회
	GoodsVO selectGoods(GoodsVO goodsVO);
	
	//상품상세 이미지 조회
	List<ImageVO> selectGoodsImages(int goodsId);
	
	//상품 구매 
	int insertBuy(BuyVO buyVO);
	
	//상품 구매 목록
	List<BuyVO> selectBuyList(SearchVO searchVO);
	
	//주문확인 버튼 변경
	int updateIsConfirm(int orderNum);
	
	//카트에 넣기
	int insertCart(CartVO cartVO);
	
	//카트리스트
	List<CartListVO> selectCartList(String memberId);
	
	//카트에서 빼기
	void deleteCart(String[] cartIdArr);
	
	//카트수량변경
	int updateCartQty(CartVO cartVO);
	
	//장바구니에서 선택한거 구매목록으로
	List<CartListVO> selectCartBuyList(String[] cartIdArr);
	
	//다중 구매
	void insertBuyList(BuyVO buyVO, String[] cartIdArr);
	
	//구매확인 변경
	void updateCartIsDelete(String[] cartIdArr);
	
	//년별 매출
	List<SalesVO> selectSales(String salesDate);
	
	//월별 매출
	List<SalesVO> selectSalesListPerMonth(String yearMonth);
	
 }




















