package com.spring.biz;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.biz.vo.ClassVO;
import com.spring.biz.vo.GradeVO;
import com.spring.biz.vo.StudentVO;

@Service("studentService") 
public class StudentServiceImpl implements StudentService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ClassVO> selectClassList() {
		return sqlSession.selectList("selectClassList");
	}

	@Override
	public List<StudentVO> selectStudentList(StudentVO studentVO) {
		return sqlSession.selectList("selectStudentList", studentVO);
	}

	@Override
	public StudentVO selectStudent(int stuNum) {
		return sqlSession.selectOne("selectStudent", stuNum);
	}

	@Override
	public int saveScore(GradeVO gradeVO) {
		return sqlSession.insert("saveScore", gradeVO);
	}

	@Override
	public GradeVO selectScore(GradeVO gradeVO) {
		return sqlSession.selectOne("selectScore", gradeVO);
	}

	@Override
	public int insertStudent(StudentVO studentVO) {
		return sqlSession.insert("insertStudent", studentVO);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteStudent(StudentVO studentVO, GradeVO gradeVO) {
		int result = deleteGrade(gradeVO) +
		sqlSession.delete("deleteStudent", studentVO);
		
		return result;
	}

	@Override
	public int deleteGrade(GradeVO gradeVO) {
		return sqlSession.delete("deleteGrade", gradeVO);
	}

	@Override
	public int insertGrade(GradeVO gradeVO) {
		return sqlSession.insert("insertGrade", gradeVO);
	}
	
}












