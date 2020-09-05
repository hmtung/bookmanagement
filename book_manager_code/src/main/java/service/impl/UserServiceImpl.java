package service.impl;

import java.util.Scanner;

import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService {

	public void checkLogin() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------ENTER USER--------------");
		String nameInput = sc.nextLine();
		System.out.println("-------------ENTER PASS--------------");
		String passInput = sc.nextLine();
		userDaoImpl.checkLogin(nameInput, passInput);
	}

	public void logOut() {
		System.out.println("------------Logout---------------");
		
	}
	

}
