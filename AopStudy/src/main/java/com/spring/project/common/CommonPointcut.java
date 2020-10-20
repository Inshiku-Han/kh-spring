package com.spring.project.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcut {
	//클래스에서 aop 설정하는 스타일
		@Pointcut("execution(* com.spring.project.board.service.*Impl.*(..))")
		public void allPointcut() {};
		
		@Pointcut("execution(void com.spring.project.board.service.*Impl.*(..))")
		public void updatePointcut() {};
		
		@Pointcut("execution(* com.spring.project.board.service.*Impl.select*(..))")
		public void selectPointcut() {};
}
