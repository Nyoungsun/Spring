package sample03;

import org.springframework.stereotype.Component;

@Component("messageBeanKo")
public class MessageBeanKo implements MessageBean{
	private int num;

	public MessageBeanKo() {
		System.out.println("Ko 기본 생성자");
	}
	
	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num = " + num);
		System.out.println("안녕하세요 " + name);
		System.out.println();
	}
	
}