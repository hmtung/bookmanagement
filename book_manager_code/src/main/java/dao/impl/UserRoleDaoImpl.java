package dao.impl;

import java.util.List;

import dao.UserRoleDao;
import mapper.UserRoleMapper;
import model.UserRole;

public class UserRoleDaoImpl extends BaseDaoImpl<UserRole> implements UserRoleDao {

	public UserRole checkLogin(String username, String password) {
		String query = "SELECT *" 
				+" FROM user_tbl AS u" 
		    +" INNER JOIN book_case_tbl AS bc"
        +" ON u.user_id = bc.user_id"
				+" INNER JOIN user_role_tbl AS us"
				+" ON u.user_id = us.user_id" 
				+" INNER JOIN role_tbl AS r" 
				+" ON us.role_id = r.role_id"
				+" WHERE u.username = ? AND u.password = ? ";
		List<UserRole> list = this.query(query, new UserRoleMapper(), username, password);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}
}
