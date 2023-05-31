package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.userService;

public class HelloSpring {
	public void menu(ApplicationContext applicationContext) {
		Scanner scanner = new Scanner(System.in);
		userService userService = null;
		
		while (true) {
			System.out.println("===== MENU =====");
			System.out.println(" 1. 입력");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 삭제");
			System.out.println(" 5. 종료");
			System.out.println("================");
			System.out.print("SELECT NUMBER: ");
			int num = scanner.nextInt();
			System.out.println();

			if (num == 5) {
				break;
			} else if (num == 1) {
				userService = (user.service.userService) applicationContext.getBean("userInsertService");
			} else if (num == 2) {
				userService = (user.service.userService) applicationContext.getBean("userSelectService");
			} else if (num == 3) {
				userService = (user.service.userService) applicationContext.getBean("userUpdateService");
			} else if (num == 4) {
				userService = (user.service.userService) applicationContext.getBean("userDeleteService");
			} else {
				System.out.println("다시 입력하세요");
				System.out.println();
				continue;
			}
			userService.execute();
		} // while

	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) applicationContext.getBean("helloSpring");
		helloSpring.menu(applicationContext);
		
		System.out.println("프로그램 종료");
		
		
	}
}
