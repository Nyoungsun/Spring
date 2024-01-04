package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public Map<String, Object> getUserList(String pg);

	public String isExist(String id);

	public UserDTO getUser(String id);

	public void update(UserDTO userDTO);

	public int delete(Map<String, String> map);

	public void upload(UserImageDTO userImageDTO, List<String> imgList);

	public List<UserImageDTO> getImgList();
}
