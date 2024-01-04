package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(Map<String, String> map);

	public List<UserDTO> getUserList();
	
	public UserDTO getUser(String id);
	
	public void update(Map<String, String> map);
	
	public int delete(String id);
}
