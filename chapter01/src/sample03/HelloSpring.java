package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
	
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/superkorean.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("superkorean.xml");
		
		MessageBean bean = (MessageBean) context.getBean("messageBean"); // 부모 = 자식 ++ 부모클래스로 잡아줘라
		bean.sayHello("Spring"); 
		
		MessageBean bean2 = context.getBean("messageBean", MessageBean.class); // 부모 = 자식 ++ 부모클래스로 잡아줘라
		bean2.sayHello("Spring");
		
		MessageBean bean3 = (MessageBean) context.getBean("messageBean"); // 부모 = 자식 ++ 부모클래스로 잡아줘라
		bean3.sayHello("Spring");
		
	}
	

}
