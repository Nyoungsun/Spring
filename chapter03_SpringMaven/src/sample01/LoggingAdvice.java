package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 공통 코드
@Aspect
@Component
public class LoggingAdvice {
	
	@Before("execution(public void sample01.MessageBeanImpl.*Before())" )
	public void beforeTrace() {
		System.out.println("Before trace");
	}
	
	@After("execution(public void sample01.MessageBeanImpl.*After())")
	public void afterTrace() {
		System.out.println("After trace");
	}
	
	@Around("execution(public * *.MessageBeanImpl.*Around(..))")
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
