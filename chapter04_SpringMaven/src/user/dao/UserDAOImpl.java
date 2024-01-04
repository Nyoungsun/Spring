package user.dao;


import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired
	public void SetDataSource(DataSource dataSource) {//
		setDataSource(dataSource); //NamedParameterJdbcDaoSupport에 있는 setDataSource()메소드 호출
	}

	@Override
	public void write(Map<String, String> map) {
		String sql = "insert into usertable values(:name, :id, :pwd)";
		
		getNamedParameterJdbcTemplate().update(sql, map);
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