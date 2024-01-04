package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements userService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("삭제할 ID 입력: ");
		String id = scanner.next();

		int count = userDAO.delete(id);

		if (count == 0) {
			System.out.println("없는 아이디 입니다.");
			System.out.println();
		} else {
			System.out.println("삭제 완료");
		}
		
	}

}
