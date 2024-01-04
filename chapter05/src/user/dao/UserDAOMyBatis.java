package user.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;

import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Setter
public class UserDAOMyBatis implements UserDAO {
	private SqlSession sqlSession;

	@Transactional
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Transactional
	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void update(Map<String, String> map) {
		sqlSession.update("userSQL.update", map);
	}

	@Override
	public int delete(String id) {
		return sqlSession.delete("userSQL.delete", id);
	}

}
