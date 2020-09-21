package com.spring.view;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.biz.StudentService;
import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

@Controller
public class AjaxController {
	@Resource(name = "studentService")
	StudentService studentservice;
	
	@RequestMapping(value = "/studentManagement.st")
	public String studentManagement(StudentVO studentVO, Model model) {
		//학급 정보 조회
		model.addAttribute("classList", studentservice.selectClassList());
		//학생 정보 조회
		model.addAttribute("studentList", studentservice.selectStudentList(studentVO));
		
		return "studentManagement";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxStudentList.st")
	public List<StudentVO> ajaxStudentList(StudentVO studentVO) {
	 List<StudentVO> list =	studentservice.selectStudentList(studentVO);
	 
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/ajaxSelectScore.st")
	public GradeVO ajaxSelectScore(GradeVO gradeVO) {
		
		return studentservice.selectScore(gradeVO);
	}
	
	//학생 추가
	@ResponseBody
	@RequestMapping(value = "/insertStudent.st")
	public int insertStudent(StudentVO studentVO) {
		
		return studentservice.insertStudent(studentVO);
	}
	
	//학생 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteStudent.st")
	public int deleteStudent(StudentVO studentVO, GradeVO gradeVO) {
			
		return studentservice.deleteStudent(studentVO, gradeVO); 
	}
	
	//학생 추가
	@ResponseBody
	@RequestMapping(value = "/insertGrade.st")
	public int insertGrade(GradeVO gradeVO) {
		
		return studentservice.insertGrade(gradeVO); 
	}
	
	
	
}










