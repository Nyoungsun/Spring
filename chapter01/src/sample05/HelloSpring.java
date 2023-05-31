package sample05;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("superkorean.xml");
		

	      SungJuklmpl sungJuklmpl;
	      sungJuklmpl = (SungJuklmpl)context.getBean("sungJuklmpl");
	      sungJuklmpl.calc();
	      sungJuklmpl.display();
		

}
}