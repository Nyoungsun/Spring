package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserInsertService implements userService {
	@Autowired
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		// 데이터
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("이름 입력: ");
		String name = scanner.next();

		System.out.print("아이디 입력: ");
		String id = scanner.next();

		System.out.print("비밀번호 입력: ");
		String pwd = scanner.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);

		// DB
		userDAO.write(userDTO);
		
		System.out.println("저장완료");

	}
}