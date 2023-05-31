package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SungJukImpl sungJukImpl = (SungJukImpl) applicationContext.getBean("sungJukImpl");
		sungJukImpl.calcTot();
		sungJukImpl.calcAvg();
		sungJukImpl.display();
		sungJukImpl.modify();
	}
}
