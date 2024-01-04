package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 공통 코드
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("Before trace");
	}
	
	public void afterTrace() {
		System.out.println("After trace");
	}
	
	public void aroundTrace(ProceedingJoinPoint joinPoint) throws Throwable {
		//앞에 삽입될 코드
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("methodName = " + methodName);
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(methodName);
		
		//핵심 코드 호출
		Object object = joinPoint.proceed();
		System.out.println(object);
		
		//뒤에 삽입될 코드
		stopWatch.stop();
		System.out.println(stopWatch.getTotalTimeSeconds());
		
		
	}
}
