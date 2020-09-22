package com.spring.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.biz.ShopService;
import com.spring.biz.vo.GoodsVO;
import com.spring.biz.vo.ImageVO;
import com.spring.biz.vo.MemberVO;
import com.spring.biz.vo.SalesVO;
import com.spring.biz.vo.SearchVO;
import com.spring.util.DateUtil;

@Controller
public class AdminController {
	@Resource(name = "shopService")
	ShopService shopService;

	// 구매관리
	@RequestMapping(value = "/manageBuy.ad")
	public String manageBuy(MemberVO memberVO, SearchVO searchVO, Model model) {
		if (searchVO.getToDate() == null || searchVO.getToDate().equals("")) {
			searchVO.setFromDate(DateUtil.getFromDate("yyyy-MM-dd"));
			searchVO.setToDate(DateUtil.getToDate("yyyy-MM-dd"));
		}

		String[] dateResult = { searchVO.getFromDate(), searchVO.getToDate() };

		model.addAttribute("buyList", shopService.selectBuyList(searchVO));
		model.addAttribute("dateResult", dateResult);

		return "admin/manageBuy";
	}

	// 구매관리에서 확인버튼 업데이트
	@ResponseBody
	@RequestMapping(value = "/updateIsConfirm.ad")
	public int updateIsConfirm(int orderNum) {

		return shopService.updateIsConfirm(orderNum);
	}

	// 상품등록 페이지로 이동
	@RequestMapping(value = "/insertItem.ad")
	public String insertItem(MemberVO memberVO, Model model) {
		// 카테고리 리스트 조회 및 데이터 전달
		model.addAttribute("categoryList", shopService.selectCategoryList());
		return "admin/insertItem";
	}

	// 상품등록
	@RequestMapping(value = "/insertGoods.ad")
	public String insertGoods(GoodsVO goodsVO, ImageVO imageVO, Model model, HttpSession session,
			MultipartHttpServletRequest multi) throws Exception {
		// 파일 첨부 후 첨부된 파일명의 List를 전달
		List<String> attachedFileNames = attachFile(multi);

		// goodsId값 지정
		int goodsId = shopService.getMaxId();
		goodsVO.setGoodsId(goodsId);

		// memderId 값 지정
		String memberId = ((MemberVO) session.getAttribute("loginInfo")).getMemberId();
		goodsVO.setGoodsWriter(memberId);

		// --SHOPPING_IMAGE 테이블에 INSERT를 하기 위한 파라메터 설정--//
		List<ImageVO> imageList = new ArrayList<>();
		for (int i = 0; i < attachedFileNames.size(); i++) {
			ImageVO vo = new ImageVO();
			String imageId = "IMG" + DateUtil.getNowDateTime() + (i + 1);
			vo.setImageId(imageId);
			vo.setGoodsId(goodsId);
			vo.setFileName(attachedFileNames.get(i));
			vo.setMemberId(memberId);
			imageList.add(vo);
		}

		imageVO.setImageList(imageList);
		shopService.insertGoods(goodsVO, imageVO);

		// 페이지 정보를 보내 줌
		model.addAttribute("mainMenu", "admin");
		model.addAttribute("subMenu", "insertItem");

		return "redirect:insertItem.ad";
	}

	// 상품관리
	@RequestMapping(value = "/manageItem.ad")
	public String manageItem(MemberVO memberVO) {
		return "admin/manageItem";
	}

	// 회원관리
	@RequestMapping(value = "/manageMember.ad")
	public String manageMember(MemberVO memberVO) {
		return "admin/manageMember";
	}

	// 매출관리
	@RequestMapping(value = "/salesManage.ad")
	public String salesManage(MemberVO memberVO, Model model) {
		
		// 실제 매출이 발생한 월별 매출액 리스트
		List<SalesVO> salesList = shopService.selectSales("2020");

		// 1~12월까지 정리된 매출액 리스트
		List<SalesVO> resultList = new ArrayList<>();

//		String a = String.format("%02d", 1); // 01
//		String b = String.format("%02d", 11); // 11

		// 1~12월까지 전부 0월으로 매출액을 세팅
		for (int i = 0; i < 12; i++) {
			SalesVO vo = new SalesVO();
			vo.setBuyMonth(String.format("%02d", i + 1));
			vo.setSalesPerMonth(0);
			resultList.add(vo);
		}

		// 있으면 삽입
		for (int i = 0; i < salesList.size(); i++) {
			for (int j = 0; j < resultList.size(); j++) {
				if (salesList.get(i).getBuyMonth().equals(resultList.get(j).getBuyMonth())) {
					resultList.get(j).setSalesPerMonth(salesList.get(i).getSalesPerMonth());
				}
			}
		}

		model.addAttribute("resultList", resultList);

		return "admin/salesManage";
	}

	// 매출관리에서 년도변경
	@ResponseBody
	@RequestMapping(value = "/salesJax.ad")
	public List<SalesVO> salesJax(String salesDate) {
		// 실제 매출이 발생한 월별 매출액 리스트
		List<SalesVO> salesList = shopService.selectSales(salesDate);

		// 1~12월까지 정리된 매출액 리스트
		List<SalesVO> resultList = new ArrayList<>();

		// 1~12월까지 전부 0월으로 매출액을 세팅
		for (int i = 0; i < 12; i++) {
			SalesVO vo = new SalesVO();
			vo.setBuyMonth(String.format("%02d", i + 1));
			vo.setSalesPerMonth(0);
			resultList.add(vo);
		}

		// 있으면 삽입
		for (int i = 0; i < salesList.size(); i++) {
			for (int j = 0; j < resultList.size(); j++) {
				if (salesList.get(i).getBuyMonth().equals(resultList.get(j).getBuyMonth())) {
					resultList.get(j).setSalesPerMonth(salesList.get(i).getSalesPerMonth());
				}
			}
		}

		return resultList;
	}
	
	//월별 매출
	@ResponseBody
	@RequestMapping(value = "/monthAjax.ad")
	public List<SalesVO> monthAjax(String yearMonth) {
		//실제 매출이 발생한 일자와 해당 일자의 매출액 합계 list
		List<SalesVO> salesList = shopService.selectSalesListPerMonth(yearMonth);
		
		//해당 월의 1일부터 마지막 일자까지의 데이터가 담긴 변수
		List<SalesVO> resultList = new ArrayList<>();
		
		//선택한 월의 마지막 일자 구하기
		Calendar cal = Calendar.getInstance();
		
		int year = Integer.parseInt(yearMonth.substring(0, 4));
		int month = Integer.parseInt(yearMonth.substring(4, 6));
		
		cal.set(year, month-1, 1);
		
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		//1일~마지막일까지 데이터 세팅
		int index = 0;
		for (int i = 0; i < lastDay; i++) {
			SalesVO vo = new SalesVO();
			String changedDay = String.format("%02d", i + 1);
			vo.setBuyDay(changedDay);

			
			if (salesList.size() != 0 && salesList != null) {
				if (changedDay.equals(salesList.get(index).getBuyDay())) {
					vo.setSalesPerDay(salesList.get(index).getSalesPerDay());
					if(index + 1 < salesList.size()) {
						index++;
					}
				} else {
					vo.setSalesPerDay(0);
				}
			} else {
				vo.setSalesPerDay(0);
			}

			resultList.add(vo);
		}
		
		
		
		return resultList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 파일첨부 메소드
	public List<String> attachFile(MultipartHttpServletRequest multi) throws Exception {
		// 원본 첨부파일 이름이 담길 변수
		String originFileName = "";
		// 현재 시간 데이터를 담을 변수
		String nowDate = DateUtil.getNowDateTime();
		// 리턴시킬 첨부파일명이 담긴 리스트 생성
		List<String> fileList = new ArrayList<>();

		// 첨부파일에 대한 encoding 설정
		multi.setCharacterEncoding("UTF-8");

		// multipartRequest에서 첨부파일에 대한 데이터를 받아온다.
		Iterator<String> enu = multi.getFileNames();

		// 첨부파일 데이터가 존재하면 첨부파일 개수만큼 반복한다.
		while (enu.hasNext()) {
			// 첨부파일의 정보를 하나씩 차례대로 꺼낸다.
			String fileName = enu.next();
			System.out.println(fileName);

			// 단일 첨부파일 일때
			if (fileName.equals("file1")) {
				// 실제 파일명(업로드되는 파일명)
				String realName = "";
				// 하나씩 꺼낸 정보를 통해 실제 파일을 받아온다.
				MultipartFile mf = multi.getFile(fileName);
				// 실제 받아온 첨부파일 정보에서 원본파일의 이름을 받아온다.
				originFileName = mf.getOriginalFilename();
				// 실제파일명을 현재날짜_원본파일 형태의 이름으로 지정
				realName = nowDate + "_" + originFileName;

				File file = new File("D:\\uploadFile\\bookStore");

				// 첨부파일의 용량이 0이 아니면
				if (mf.getSize() != 0) {
					if (!file.exists()) {
						file.mkdirs();
					}
					// 해당하는 경로에 첨부파일을 업로드한다.
					mf.transferTo(new File("D:\\uploadFile\\bookStore\\" + realName));
					fileList.add(realName);
				}
			}
			// 다중 첨부파일 일때
			else if (fileName.equals("file2")) {
				List<MultipartFile> mfList = multi.getFiles(fileName);
				String realName = "";

				for (MultipartFile mf : mfList) {
					originFileName = mf.getOriginalFilename();
					realName = nowDate + "_" + originFileName;
					File file = new File("D:\\uploadFile\\bookStore");

					// 첨부파일의 용량이 0이 아니면
					if (mf.getSize() != 0) {
						if (!file.exists()) {
							file.mkdirs();
						}
						// 해당하는 경로에 첨부파일을 업로드한다.
						mf.transferTo(new File("D:\\uploadFile\\bookStore\\" + realName));
						fileList.add(realName);
					}
				}
			}
		}
		return fileList;
	}

}
