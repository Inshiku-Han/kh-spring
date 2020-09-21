package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

@Service("studentService") 
public class StudentServiceImpl implements StudentService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<StudentVO> selectStudentList(StudentVO studentVO) {
		return sqlSession.selectList("selectStudentList", studentVO);
	}

	@Override
	public List<StudentVO> selectClassInfo() {
		return sqlSession.selectList("selectClassInfo");
	}

	@Override
	public StudentVO selectStudent(int stuNum) {
		return sqlSession.selectOne("selectStudent", stuNum);
	}

	@Override
	public GradeVO selectGrade(int stuNum) {
		return sqlSession.selectOne("selectGrade", stuNum);
	}

	@Override
	public int insertGrade(GradeVO gradeVO) {
		return sqlSession.insert("insertGrade", gradeVO);
	}

	@Override
	public int updateGrade(GradeVO gradeVO) {
		return sqlSession.update("updateGrade", gradeVO);
	}
	
}












