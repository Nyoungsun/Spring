package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;

@Configuration // applicationContext.xml과 같은 역할을 함 → Bean 생성
public class SpringConfiguration {
	
	// sample01
	@Bean
	public MessageBeanImpl messageBeanImpl() {
		return new MessageBeanImpl("사과");
	}
	
	// sample02
	@Bean
	public CalcAdd calcAdd() {
		return new CalcAdd(22, 47);
	}
	
	// sample03
	@Bean
	public CalcMul calcMul() {
		return new CalcMul();
	}
}

/*
 메소드에서 return되는 값을 Bean으로 생성
 메소드명은 반드시 Bean의 id명과 같아야함
 */
