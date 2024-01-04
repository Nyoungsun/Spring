package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sample03.MessageBean;

public class HelloSpring {
	public static void main(String[] args) {
		//ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Calc calc;
		
		calc = (Calc) applicationContext.getBean("calcAdd");
		calc.calculate(25, 36);
		
		calc  = (Calc) applicationContext.getBean("calcMul");
		calc.calculate(25, 36);

	}
}