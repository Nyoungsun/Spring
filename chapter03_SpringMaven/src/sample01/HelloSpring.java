package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("acQuickStart.xml");
		MessageBean messageBean = (MessageBean) applicationContext.getBean("messageBeanImpl");
		
		/* before
		messageBean.showPrintBefore();
		System.out.println();
		messageBean.viewPrintBefore();
		System.out.println();
		messageBean.display();
		*/
		
		/* after
		messageBean.showPrintAfter();
		System.out.println();
		messageBean.viewPrintAfter();
		System.out.println();
		messageBean.display();
		*/
		
		//around
		messageBean.showPrintAround();
		System.out.println();
		messageBean.viewPrintAround();
		System.out.println();
		messageBean.display();
	}
}