package sample03;

public class MessageBeanEn implements MessageBean {
	public MessageBeanEn() {
		System.out.println("En 기본 생성자");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("Hi " + name);
	}
}