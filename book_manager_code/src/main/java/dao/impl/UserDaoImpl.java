package dao.impl;

import java.util.Scanner;

import dao.UserDao;
import model.User;
import util.Constants;
import util.ValidatorUtil;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	public User checkLogin(String name, String pass, Scanner scanner) {
		
		String query = "SELECT  * FROM " + Constants.USER_TABLE_NAME + " WHERE username LIKE 'AD%'";
		String query1 = "SELECT  * FROM " + Constants.USER_TABLE_NAME + " WHERE username LIKE 'U%'";
		Object[] params = new Object[] { name };
		if (checkLogin(query, name, pass, params) == true) {
			System.out.println("----------------ADMIN LOGIN------------");
			System.out.println("1. Create book");
			System.out.println("2. Update book");
			System.out.println("3. Delete book");
			int check = ValidatorUtil.inputSelectedMenu(scanner);
			switch (check) {
			case 1:
				System.out.println("1. Create book");
				break;
			case 2:
				System.out.println("2. Update book");
				break;
			case 3:
				System.out.println("3. Delete book");
				break;

			}
		} else if (checkLogin(query1, name, pass, params) == true) {
			System.out.println("----------------USER LOGIN------------");
			System.out.println("1. View list book");
			System.out.println("2. View book detail");
			System.out.println("3. Search book");
			System.out.println("4. View bookcase");
			System.out.println("5. Edit bookcase");
			int check = ValidatorUtil.inputSelectedMenu(scanner);
			switch (check) {
			case 1:
				System.out.println("1. View list book");
				break;
			case 2:
				System.out.println("2. View book detail");
				break;
			case 3:
				System.out.println("3. Search book");
				break;
			case 4:
				System.out.println("4. View bookcase");
				break;
			case 5:
				System.out.println("5. Edit bookcase");
				break;
			}
		} else {
			System.out.println("Invalid");
		}
		return new User(name, pass);
	}
}
