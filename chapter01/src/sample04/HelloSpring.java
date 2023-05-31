package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample03.MessageBean;

public class HelloSpring {
	
	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("superkorean.xml");
		
		Calc calc = (Calc) context.getBean("CalcAdd"); // 부모 = 자식 ++ 부모클래스로 잡아줘라
		calc.calculate(25, 36); 
		
		Calc calc2 = (Calc) context.getBean("CalcMul"); // 부모 = 자식 ++ 부모클래스로 잡아줘라
		calc2.calculate(25, 36); 
	}

	
}
