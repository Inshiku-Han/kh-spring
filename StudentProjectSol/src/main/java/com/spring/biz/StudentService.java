package com.spring.biz;

import java.util.List;

import com.spring.biz.vo.ClassVO;
import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

public interface StudentService {
	//학급 리스트 조회
	public List<ClassVO> selectClassList();
	//학생 조회
	public List<StudentVO> selectStudentList(StudentVO studentVO);
	//학생 상세 조회
	public StudentVO selectStudent(int stuNum);
	//점수 정보 저장
	public int saveScore(GradeVO gradeVO);
	//학생 점수 조회
	public GradeVO selectScore(GradeVO gradeVO);
	//학생 추가
	public int insertStudent(StudentVO studentVO);
	//학생 삭제
	public int deleteStudent(StudentVO studentVO, GradeVO gradeVO);
	//점수 삭제
	public int deleteGrade(GradeVO gradeVO);
	//점수 등록
	public int insertGrade(GradeVO gradeVO);
	
}




















