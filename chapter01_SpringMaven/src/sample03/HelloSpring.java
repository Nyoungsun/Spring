package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		//ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean messageBean =  (MessageBean) applicationContext.getBean("messageBeanKo");
		messageBean.sayHello("Spring");
		
		MessageBean messageBean2 =  applicationContext.getBean("messageBeanKo", MessageBean.class);
		messageBean2.sayHello("Spring");
		
		MessageBean messageBean3 =  (MessageBean) applicationContext.getBean("messageBeanKo");
		messageBean3.sayHello("Spring");
	}
}