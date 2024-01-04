package user.service;

import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.HashedMap;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserUpdateService implements userService {
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("ID 입력: "); // ID - PK
		String id = scanner.next();

		UserDTO userDTO = userDAO.getUser(id);
		if (userDTO == null) {
			System.out.println("정보 없음");
			return;
		}
		
		if (id.equals(userDTO.getId())) {

			System.out.println("이름\tID\tPWD");
			System.out.println(userDTO);
			System.out.println();

			System.out.print("변경할 이름:");
			String name = scanner.next();
			System.out.print("변경할 PWD:");
			String pwd = scanner.next();

			// 저장
			Map<String, String> map = new HashedMap<>();
			map.put("id", id);
			map.put("name", name);
			map.put("pwd", pwd);

			userDAO.update(map);

			System.out.println();
			System.out.println("수정 완료");
			System.out.println();
		}
	}
}
