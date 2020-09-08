package dao;

import model.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRoleDao.
 */
public interface UserRoleDao {
	
	/**
	 * Check login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the user role
	 */
	UserRole checkLogin(String username, String password);
}
