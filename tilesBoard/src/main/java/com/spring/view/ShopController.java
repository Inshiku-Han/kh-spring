package com.spring.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.ShopService;
import com.spring.biz.vo.BuyVO;
import com.spring.biz.vo.CartVO;
import com.spring.biz.vo.GoodsVO;
import com.spring.biz.vo.MemberVO;

@Controller
public class ShopController {
	@Resource(name = "shopService")
	ShopService shopService;
	
	//상품 목록 조회
	@RequestMapping(value = "/shopList.sh")
	public String sample(GoodsVO goodsVO, Model model) {
		//카테고리 목록 조회
		model.addAttribute("categoryList", shopService.selectCategoryList());
		
		//도서상품 목록 조회
		model.addAttribute("goodsList", shopService.selectGoodsList(goodsVO));
		return "shop/shopList"; 
	}
	
	//상품 상세보기
	@RequestMapping(value = "/shopDetail.sh")
	public String shopDetail(GoodsVO goodsVO, Model model) {
		//카테고리 목록 조회
		model.addAttribute("categoryList", shopService.selectCategoryList());
		
		//페이지 정보 설정
		goodsVO.setMainMenu("shopping");
		
		//상세정보조회(상세이미지제외)
		model.addAttribute("goodsDetail", shopService.selectGoods(goodsVO));
		//상세이미지 리스트 조회
		model.addAttribute("imageList", shopService.selectGoodsImages(goodsVO.getGoodsId()));
				
		return "shop/shopDetail"; //template.jsp
	}
	
	//구매정보페이지
	@RequestMapping(value = "/buyPage.sh")
	public String buyPage(GoodsVO goodsVO, int cnt, Model model) {
		//카테고리 목록 조회
		model.addAttribute("categoryList", shopService.selectCategoryList());
		
		//도서상세정보조회
		model.addAttribute("goodsDetail", shopService.selectGoods(goodsVO));
		model.addAttribute("cnt", cnt); //수량
		
		return "shop/buyPage"; //template.jsp
	}
	
	//상품구매
	@RequestMapping(value = "/insertBuy.sh")
	public String insertBuy(BuyVO buyVO, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("loginInfo");
		buyVO.setMemberId(memberVO.getMemberId());
		buyVO.setMemberName(memberVO.getMemberName());
		buyVO.setMemberTel1(memberVO.getTel1());
		buyVO.setMemberTel2(memberVO.getTel2());
		buyVO.setMemberAddr(memberVO.getMemberAddr());
		
		shopService.insertBuy(buyVO);
		
		return "redirect:shopList.sh"; //template.jsp
	}
	
	//장바구니에 넣기
	@ResponseBody
	@RequestMapping(value = "/insertCart.sh")
	public String insertCart(CartVO cartVO) {
		
		
		return ""+shopService.insertCart(cartVO);
	}
	
	//장바구니로 가기
	@RequestMapping(value = "/cartList.sh")
	public String cartList(HttpSession session, Model model) {
		
		model.addAttribute("cartList", 
			shopService.selectCartList(
				((MemberVO)session.getAttribute("loginInfo")).getMemberId()
			)
		);
		return "shop/cartList";
	}
	
	
	
}










