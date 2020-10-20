package com.spring.project.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.spring.project.board.vo.BoardVO;

@Service("adivce")
@Aspect //포인트컷 + 어드바이스
public class AnnoAdvice{
	
	
	// 매개변수로 필요한 데이터가 제대로 매핑되어있는지 확인.
	@Before("CommonPointcut.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		// signature -> 실제 호출되는 메소드의 리턴타입, 이름, 매개변수 정보
		String methodName = jp.getSignature().getName();
		// 호출되는 메소드에 사용되는 매개변수의 정보를 받아 옴.
		Object[] args = jp.getArgs();
		if(args.length != 0) {
			System.out.println("\n[사전 처리]" + methodName + "() ARGS 정보 : " + args[0].toString());
		}

	}

	// after-returning
	@AfterReturning(pointcut = "CommonPointcut.selectPointcut()", returning = "returnObj")
	public void afterSelectLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();

		// returnObj가 BoardVO 타입의 객체라면...
		if (returnObj instanceof BoardVO) {
			BoardVO vo = (BoardVO) returnObj;
			System.out.println("return 정보 : " + vo.toString());
		}
		System.out.println("[사후 처리] 데이터 조회 완료\n");
	}
	
	@Around("CommonPointcut.selectPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] - 메소드 실행 전 처리");
		String methodName = pjp.getSignature().getName();
		StopWatch watch = new StopWatch();
		watch.start();
		Object returnObj = pjp.proceed(); // 실행할 메소드의 순서를 지정. 출력 - 메소드 실행 - 출력
		watch.stop();
		System.out.println("[AFTER] " + methodName + "() 수행시간 : " + watch.getTotalTimeMillis());

		return returnObj; // 리턴형 메소드를 실행할 때 이 메소드에서 리턴을 줘야 값을 받음.(ex)selectBoardList는 return으로 List<BoardVO>가 필요)
	}
}
