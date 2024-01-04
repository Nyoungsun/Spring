package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		Calc calcadd = (Calc) applicationContext.getBean("calcAdd");
		calcadd.calculate();
		
		Calc calcMul = (Calc) applicationContext.getBean("calcMul");
		calcMul.calculate();
	}
}
