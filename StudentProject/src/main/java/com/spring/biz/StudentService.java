package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

public interface StudentService {
	//리스트조회
	public List<StudentVO> selectStudentList(StudentVO studentVO);
	//셀렉트변경
	public List<StudentVO> selectClassInfo();
	//상세조회
	public StudentVO selectStudent(int stuNum);
	//상세조회(성적)
	public GradeVO selectGrade(int stuNum);
	//성적 등록
	public int insertGrade(GradeVO gradeVO);
	//성적 수정
	public int updateGrade(GradeVO gradeVO);
}




















