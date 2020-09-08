package view;

import java.util.Scanner;

import service.UserService;
import service.impl.UserServiceImpl;

public class Main {
	public static UserService userService;
	public static Scanner scanner;

	public static void init() {
		userService = new UserServiceImpl();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		init();
		int select;
		try {
			while (true) {
				System.out.println("======= READING BOOK MANAGEMENT SYSTEM =======");
				System.out.println("1. Login");
				System.out.println("2. Logout");

				System.out.println("============================");

				System.out.print("=> Choose: ");
				select = scanner.nextInt();
				scanner.nextLine();

				switch (select) {
				case 1:
					UserServiceImpl userServiceImpl = new UserServiceImpl();
//					userServiceImpl.checkLogin();
					break;
				case 2:
					UserServiceImpl impl = new UserServiceImpl();
					impl.logOut();
					break;
				case 3:
					System.out.println("Close program");
					return;
				}
				System.out.println();
			}
		} finally {
			scanner.close();
		}
	}
}
