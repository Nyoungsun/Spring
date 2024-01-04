package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserInsertService implements userService {
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
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		// DB
		userDAO.write(map);
		
		System.out.println("저장완료");

	}
}