package dao;

import model.UserRole;

public interface UserRoleDao {
	UserRole checkLogin(String username, String password);
}
