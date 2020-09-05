package dao.impl;

import dao.UserDao;
import model.User;
import util.Constants;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User checkLogin(String name, String pass) {
		String query = "SELECT  username,password FROM " + Constants.USER_TABLE_NAME + " WHERE username LIKE 'AD%'";
		String query1 = "SELECT  username,password FROM " + Constants.USER_TABLE_NAME + " WHERE username LIKE 'U%'";
		Object[] params = new Object[] { name };
		if (checkLogin(query, name, pass, params) == true) {
			System.out.println("----------------ADMIN LOGIN------------");
			System.out.println("1. Create book");
            System.out.println("2. Update book");
            System.out.println("3. Delete book");
		} else if (checkLogin(query1, name, pass, params) == true) {
			System.out.println("----------------USER LOGIN------------");
			 System.out.println("1. View list book");
             System.out.println("2. View book detail");
             System.out.println("3. Search book");
             System.out.println("4. View bookcase");
             System.out.println("5. Edit bookcase");
		} else {
			System.out.println("Invalid");
		}
		return new User(name, pass);
	}
}
