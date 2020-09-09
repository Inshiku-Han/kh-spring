package com.spring.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.StudentService;
import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

@Controller
public class StudentController {
	@Resource(name = "studentService")
	StudentService service;
	
	@RequestMapping(value = "/studentList.do")
	public String selectstudentList(StudentVO studentVO, Model model) {
		if(studentVO.getClassCode() == 0) {
			studentVO.setClassCode(1);
		}
		model.addAttribute("list", service.selectStudentList(studentVO));
		model.addAttribute("select", service.selectClassInfo());
		return "studentList";
	}
	//상세보기
	@RequestMapping(value = "/studentDetail.do")
	public String selectStudent(int stuNum, Model model) {
		
		model.addAttribute("student", service.selectStudent(stuNum));
		model.addAttribute("grade", service.selectGrade(stuNum));
		return "studentDetail";
	}
	@RequestMapping(value = "/insertGrade.do", method = RequestMethod.GET)
	public String insertGradeForm(int stuNum, Model model) {
		
		model.addAttribute("insik", stuNum);
		return "insertGradeForm";
	}
	@RequestMapping(value = "/insertGrade.do", method = RequestMethod.POST)
	public String insertGrade(GradeVO gradeVO, Model model) {
		service.insertGrade(gradeVO);
		model.addAttribute("stuNum", gradeVO.getStuNum());
		return "redirect:studentDetail.do";
	}
	
	//성적 수정
	@RequestMapping(value = "/updateGrade.do")
	public String updateGrade(GradeVO gradeVO, Model model) {
		service.updateGrade(gradeVO);
		
		model.addAttribute("stuNum", gradeVO.getStuNum());
		return "redirect:studentDetail.do";
	}
	
	

}










