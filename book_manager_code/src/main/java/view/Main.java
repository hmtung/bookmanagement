package view;

import java.util.Scanner;

import service.UserService;
import service.impl.UserServiceImpl;
import util.Constants;
import util.ValidatorUtil;

public class Main {
  public static UserService userService;
  public static Scanner scanner;

  public static void init() {
    userService = new UserServiceImpl();
    scanner = new Scanner(System.in);
  }

  public static void main(String[] args) {
    init();
    userService.checkLogin(scanner);
    Boolean login = ValidatorUtil.checkLogin(Constants.USER_ROLE);
    if (login) {
      System.out.println("Hello " + Constants.USER_ROLE.getUser().getUsername()
          + ". Please selected function bellow by entering");
      selectedMenu();
    } else {
      System.out.println("Login fail");
    }

  }

  public static void selectedMenu() {
    int select;
    try {
      while (true) {
        System.out.println("1. View List Book");
        System.out.println("2. Search Book");
        System.out.println("3. Read Book");
        System.out.println("4. View Your BookCase");
        System.out.println("5. Edit Your Book Case");
        System.out.println("6. Create Book");
        System.out.println("7. Update Content Book");
        System.out.println("8. Dalete Book");
        System.out.println("9. Logout");
        select = ValidatorUtil.inputSelectedMenu(scanner);
        switch (select) {
        case 1:
          System.out.println("1");
          break;
        case 2:
          System.out.println("2");
          break;
        case 3:
          System.out.println("3");
          break;
        case 4:
          System.out.println("4");
          break;
        case 5:
          System.out.println("5");
          break;
        case 6:
          System.out.println("6");
          break;
        case 7:
          System.out.println("7");
          break;
        case 8:
          System.out.println("8");
          break;
        case 9:
          System.out.println("9");
          break;
        }

        System.out.println();
      }
    } finally {
      scanner.close();
    }
  }
}
