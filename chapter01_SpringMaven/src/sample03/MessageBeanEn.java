package sample03;

import org.springframework.stereotype.Component;

@Component("messageBeanEn")
public class MessageBeanEn implements MessageBean {
	public MessageBeanEn() {
		System.out.println("En 기본 생성자");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("Hi " + name);
	}
}