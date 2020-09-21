package com.spring.view;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.StudentService;
import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

@Controller
public class StudentController {
	@Resource(name = "studentService")
	StudentService studentservice;
	
	@RequestMapping(value = "/studentList.do")
	public String studentList(StudentVO studentVO, Model model) {
		model.addAttribute("classList", studentservice.selectClassList());
		model.addAttribute("studentList", studentservice.selectStudentList(studentVO));
		return "studentList";
	}
	@RequestMapping(value = "/studentDetail.do")
	public String studentDetail(int stuNum, Model model){
		 
		model.addAttribute("student", studentservice.selectStudent(stuNum));
		return "studentDetail";
	}
	@RequestMapping(value = "/saveScore.do")
	public String saveScore(GradeVO gradeVO){
		studentservice.saveScore(gradeVO);
		return "redirect:studentList.do";
	}
}










