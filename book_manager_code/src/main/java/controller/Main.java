package controller;

import java.util.Scanner;

import service.BookCaseService;
import service.BookService;
import service.UserService;
import service.impl.BookCaseServiceImpl;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;
import util.Constants;
import util.MessageUtil;
import util.ValidatorUtil;

public class Main {
  public static UserService userService;
  public static Scanner scanner;
  public static BookService bookService;
  public static BookCaseService bookCaseService;
  public static Boolean isAdmin;

  public static void init() {
    userService = new UserServiceImpl();
    scanner = new Scanner(System.in);
    bookService = new BookServiceImpl();
    bookCaseService = new BookCaseServiceImpl();
  }

  public static void main(String[] args) {
    init();
    userService.checkLogin(scanner);
    Boolean login = ValidatorUtil.checkLogin(Constants.USER_ROLE);
    if (login) {
      System.out.println("Hello " + Constants.USER_ROLE.getUser().getUsername()
          + ". Please selected function bellow by entering");
      isAdmin = ValidatorUtil.checkRoleAdmin(Constants.USER_ROLE);
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
        System.out.println("8. Delete Book");
        System.out.println("9. Logout");
        select = ValidatorUtil.inputSelectedMenu(scanner);
        switch (select) {
        case 1:
          bookService.viewListBook();
          break;
        case 2:
          bookService.searchBook(scanner);
          break;
        case 3:
          bookService.readBook(scanner);
          break;
        case 4:
          bookCaseService.viewBookCase(Constants.USER_ROLE.getUser().getId());
          break;
        case 5:
          bookCaseService.editBookCase(scanner, Constants.USER_ROLE.getUser());
          break;
        case 6:
          if (isAdmin) {
            bookService.insertBook(scanner);
          } else {
            System.out.println(MessageUtil.DO_NOT_PERMISSION);
          }
          break;
        case 7:
          if (isAdmin) {
            bookService.updateContentBook(scanner);
          } else {
            System.out.println(MessageUtil.DO_NOT_PERMISSION);
          }
          break;
        case 8:
          if (isAdmin) {
            bookService.deleteById(scanner);
          } else {
            System.out.println(MessageUtil.DO_NOT_PERMISSION);
          }
          break;
        case 9:
          userService.logOut();
          userService.checkLogin(scanner);
          Boolean login = ValidatorUtil.checkLogin(Constants.USER_ROLE);
          if (login) {
            System.out.println("Hello " + Constants.USER_ROLE.getUser().getUsername()
                + ". Please selected function bellow by entering");
            isAdmin = ValidatorUtil.checkRoleAdmin(Constants.USER_ROLE);
          } else {
            System.out.println("Login fail");
          }
          break;
        }

        System.out.println();
      }
    } finally {
      scanner.close();
    }
  }
}
