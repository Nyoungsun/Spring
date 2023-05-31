package user.service;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserSelectService implements userService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		
		System.out.println("이름\tID\tPWD");
		for(UserDTO userDTO: list) {
			System.out.printf("%s\t%s\t%s", userDTO.getName(), userDTO.getId(), userDTO.getPwd());
			System.out.println();
		}
		System.out.println();
	}
}
