package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;
import user.bean.UserImageDTO;

@Repository
@Transactional
public class userDAOMyBatis implements UserDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public List<UserDTO> getUserList(Map<String, Integer> map) {
		return sqlSession.selectList("userSQL.getUserList", map);
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userSQL.update", userDTO);
	}

	@Override
	public int delete(Map<String, String> map) {
		return sqlSession.delete("userSQL.delete", map);	
	}

	@Override
	public int totalArticle() {
		return sqlSession.selectOne("userSQL.totalArticle");
	}

	@Override
	public void upload(UserImageDTO userImageDTO, List<String> imgList) {
		for(String fileName : imgList) {
			userImageDTO.setImage(fileName);
			sqlSession.insert("userSQL.upload", userImageDTO);
		}
	}

	@Override
	public List<UserImageDTO> getImgList() {
		return sqlSession.selectList("userSQL.getImgList");
	}
}
