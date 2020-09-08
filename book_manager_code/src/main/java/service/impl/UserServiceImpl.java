package service.impl;

import java.util.Scanner;

import dao.UserRoleDao;
import dao.impl.UserDaoImpl;
import dao.impl.UserRoleDaoImpl;
import model.UserRole;
import service.UserService;
import util.Constants;
import util.ValidatorUtil;

public class UserServiceImpl implements UserService {

	private UserRoleDao userRoleDao;

	public UserServiceImpl() {
		userRoleDao = new UserRoleDaoImpl();
	}

	public void logOut() {
		System.out.println("------------Logout---------------");
	}

	public void checkLogin(Scanner scanner) {
		System.out.println("=========Login========");
		String username = ValidatorUtil.inputString("Nhập username: ", scanner);
		String password = ValidatorUtil.inputString("Nhập password: ", scanner);
		UserRole userRole = userRoleDao.checkLogin(username, password);
		if (userRole == null) {
			System.out.println("Login Fail");
		} else {
			Constants.USER_ROLE = userRole;
			System.out.println("Login success");
		}
	}

}
