package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.bean.UserImageDTO;
import user.bean.UserPaging;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserPaging userPaging;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public String isExist(String id) {
		UserDTO userDTO = userDAO.getUser(id);

		if (userDTO == null) {
			return "nonExist";
		} else {
			return "exist";
		}
	}

	@Override
	public UserDTO getUser(String id) {
		return userDAO.getUser(id);
	}

	@Override
	public void update(UserDTO userDTO) {
		userDAO.update(userDTO);
	}

	@Override
	public int delete(Map<String, String> map) {
		return userDAO.delete(map);
	}

	@Override
	public Map<String, Object> getUserList(String pg) {
		
		int end = Integer.parseInt(pg) * 3;
		int start = end - 2;
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<UserDTO> list = userDAO.getUserList(map);
		
		//페이징 처리
		userPaging.setCurrentPage(Integer.parseInt(pg));
		userPaging.setPageBlock(3);
		userPaging.setPageSize(3);
		userPaging.setTotalArticle(userDAO.totalArticle());
		userPaging.makePaging();
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("list", list);
		resultMap.put("userPaging", userPaging);
		
		return resultMap;
	}

	@Override
	public void upload(UserImageDTO userImageDTO, List<String> imgList) {
		userDAO.upload(userImageDTO, imgList);
	}

	@Override
	public List<UserImageDTO> getImgList() {
		return userDAO.getImgList();
	}
}
