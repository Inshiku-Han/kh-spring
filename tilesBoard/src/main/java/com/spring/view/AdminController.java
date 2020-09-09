package com.spring.view;

import java.io.File;
import java.util.ArrayList;
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
import com.spring.biz.vo.SearchVO;
import com.spring.util.DateUtil;

@Controller
public class AdminController {
	@Resource(name = "shopService")
	ShopService shopService;
	
	//구매관리
	@RequestMapping(value = "/manageBuy.ad")
	public String manageBuy(MemberVO memberVO, SearchVO searchVO, Model model) {
		if(searchVO.getToDate() == null || searchVO.getToDate().equals("")) {
			searchVO.setFromDate(DateUtil.getFromDate("yyyy-MM-dd"));
			searchVO.setToDate(DateUtil.getToDate("yyyy-MM-dd"));
		}
		
		
		String[] dateResult = { searchVO.getFromDate(), searchVO.getToDate() };
		
		model.addAttribute("buyList", shopService.selectBuyList(searchVO));
		model.addAttribute("dateResult", dateResult);
		
		
		return "admin/manageBuy"; 
	}
	
	//구매관리에서 확인버튼 업데이트
	@ResponseBody
	@RequestMapping(value = "/updateIsConfirm.ad")
	public int updateIsConfirm(int orderNum) {
			
		return shopService.updateIsConfirm(orderNum);
	}
	
	//상품등록 페이지로 이동
	@RequestMapping(value = "/insertItem.ad")
	public String insertItem(MemberVO memverVO, Model model) {
		//카테고리 리스트 조회 및 데이터 전달
		model.addAttribute("categoryList", shopService.selectCategoryList());
		return "admin/insertItem"; 
	}
	
	//상품등록
	@RequestMapping(value = "/insertGoods.ad")
	public String insertGoods(GoodsVO goodsVO, ImageVO imageVO, Model model, HttpSession session, MultipartHttpServletRequest multi) throws Exception {
		//파일 첨부 후 첨부된 파일명의 List를 전달
		List<String> attachedFileNames = attachFile(multi);

		//goodsId값 지정
		int goodsId = shopService.getMaxId();
		goodsVO.setGoodsId(goodsId);
		
		//memderId 값 지정
		String memberId = ((MemberVO)session.getAttribute("loginInfo")).getMemberId();
		goodsVO.setGoodsWriter(memberId);

		//--SHOPPING_IMAGE 테이블에 INSERT를 하기 위한 파라메터 설정--//
		List<ImageVO> imageList = new ArrayList<>();
		for(int i = 0 ; i < attachedFileNames.size() ; i++) {
			ImageVO vo = new ImageVO();
			String imageId = "IMG" + DateUtil.getNowDateTime() +(i + 1);
			vo.setImageId(imageId);
			vo.setGoodsId(goodsId);
			vo.setFileName(attachedFileNames.get(i));
			vo.setMemberId(memberId);
			imageList.add(vo);
		}
		
		imageVO.setImageList(imageList);
		shopService.insertGoods(goodsVO, imageVO);
		
		//테이지 정보를 보내 줌
		model.addAttribute("mainMenu", "admin");
		model.addAttribute("subMenu", "insertItem");
		
		return "redirect:insertItem.ad"; 
	}
	
	//상품관리
	@RequestMapping(value = "/manageItem.ad")
	public String manageItem(MemberVO memverVO) {
		return "admin/manageItem"; 
	}
	
	//회원관리
	@RequestMapping(value = "/manageMember.ad")
	public String manageMember(MemberVO memverVO) {
		return "admin/manageMember"; 
	}
	
	//파일첨부 메소드
	public List<String> attachFile(MultipartHttpServletRequest multi) throws Exception {
		//원본 첨부파일 이름이 담길 변수
		String originFileName = "";
		//현재 시간 데이터를 담을 변수
		String nowDate = DateUtil.getNowDateTime();
		//리턴시킬 첨부파일명이 담긴 리스트 생성
		List<String> fileList = new ArrayList<>();
		
		//첨부파일에 대한 encoding  설정
		multi.setCharacterEncoding("UTF-8");
		
		//multipartRequest에서 첨부파일에 대한 데이터를 받아온다.
		Iterator<String> enu = multi.getFileNames();
		
		//첨부파일 데이터가 존재하면 첨부파일 개수만큼 반복한다.
		while(enu.hasNext()) {
			//첨부파일의 정보를 하나씩 차례대로 꺼낸다. 
			String fileName = enu.next();
			System.out.println(fileName);
			
			//단일 첨부파일 일때
			if(fileName.equals("file1")) {
				//실제 파일명(업로드되는 파일명)
				String realName = "";
				//하나씩 꺼낸 정보를 통해 실제 파일을 받아온다.
				MultipartFile mf = multi.getFile(fileName);
				//실제 받아온 첨부파일 정보에서 원본파일의 이름을 받아온다.
				originFileName = mf.getOriginalFilename();
				//실제파일명을 현재날짜_원본파일 형태의 이름으로 지정
				realName = nowDate + "_" + originFileName;
				
				File file = new File("D:\\uploadFile\\bookStore");
				
				//첨부파일의 용량이 0이 아니면
				if(mf.getSize() != 0) {
					if(!file.exists()) {
						file.mkdirs();
					}
					//해당하는 경로에 첨부파일을 업로드한다.
					mf.transferTo(new File("D:\\uploadFile\\bookStore\\" + realName));
					fileList.add(realName);
				}
			}
			//다중 첨부파일 일때
			else if(fileName.equals("file2")) {
				List<MultipartFile> mfList = multi.getFiles(fileName);
				String realName = "";
				
				for(MultipartFile mf : mfList) {
					originFileName = mf.getOriginalFilename();
					realName = nowDate + "_" + originFileName;
					File file = new File("D:\\uploadFile\\bookStore");
					
					//첨부파일의 용량이 0이 아니면
					if(mf.getSize() != 0) {
						if(!file.exists()) {
							file.mkdirs();
						}
						//해당하는 경로에 첨부파일을 업로드한다.
						mf.transferTo(new File("D:\\uploadFile\\bookStore\\" + realName));
						fileList.add(realName);
					}
				}
			}
		}
		return fileList;
	}
	
	
}










