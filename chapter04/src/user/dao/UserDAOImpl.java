package user.dao;


import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import user.bean.UserDTO;

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	// JdbcDaoSupport를 상속받으면 JdbcTemplate 필요 X
	// NamedParameterJdbcDaoSupport는 JdbcDaoSupport의 최신버전
	// SQL query 물음표 자리에 이름을 부여할 수 있어서 'Named'이다.

	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(:name, :id, :pwd)";
		
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";

		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id = :id";
		try {
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name = :name, pwd = :pwd where id = :id";

		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public int delete(String id) {
		String sql = "delete from usertable where id = :id";

		int count = getJdbcTemplate().update(sql, id);

		return count;

	}

}

/*
 * 
 * @Setter public class UserDAOImpl implements UserDAO{ private JdbcTemplate
 * jdbcTemplate = null;
 * 
 * @Override public void write(UserDTO userDTO) { String sql =
 * "insert into usertable values(?, ?, ?)"; jdbcTemplate.update(sql,
 * userDTO.getName(), userDTO.getId(), userDTO.getPwd()); }
 * 
 * @Override public List<UserDTO> getUserList() { String sql =
 * "select * from usertable";
 * 
 * return jdbcTemplate.query(sql, new
 * BeanPropertyRowMapper<UserDTO>(UserDTO.class)); } }
 */