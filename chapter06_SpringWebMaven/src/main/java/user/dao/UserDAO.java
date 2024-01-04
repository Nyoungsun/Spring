package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public List<UserDTO> getUserList(Map<String, Integer> map);

	public UserDTO getUser(String id);

	public void update(UserDTO id);

	public int delete(Map<String, String> map);
	
	public int totalArticle();

	public void upload(UserImageDTO userImageDTO, List<String> imgList);

	public List<UserImageDTO> getImgList();

}
