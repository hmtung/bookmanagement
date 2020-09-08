package util;

import java.util.Scanner;

import exception.CustomException;
import model.User;
import model.UserRole;

public class ValidatorUtil {
  public static int inputSelectedMenu(Scanner scanner) {
    int selected;
    do {
      try {
        System.out.print("Please choice one option: ");
        selected = Integer.parseInt(scanner.nextLine());
        break;
      } catch (Exception e) {
        System.out.println(MessageUtil.SELECTED_MENU_ERROR_MESSAGE);
      }
    } while (true);
    return selected;
  }

  public static int inputInteger(String message, Scanner scanner) {
    int input;
    do {
      try {
        System.out.println(message);
        input = Integer.parseInt(scanner.nextLine());
        break;
      } catch (Exception e) {
        System.out.println(MessageUtil.WRONG_FORMAT);
      }
    } while (true);
    return input;
  }

  public static float inputFloat(String message, Scanner scanner) {
    float input;
    do {
      try {
        System.out.println(message);
        input = Float.parseFloat(scanner.nextLine());
        break;
      } catch (Exception e) {
        System.out.println(MessageUtil.WRONG_FORMAT);
      }
    } while (true);
    return input;
  }

  public static String inputString(String message, Scanner scanner) {
    System.out.println(message);
    return scanner.nextLine();
  }

  public static Boolean checkRoleAdmin(UserRole user) {
    try {
      if (!user.getRole().getAuthority().equals("ADMIN")) {
        throw new CustomException(MessageUtil.DO_NOT_PERMISSION);
      }
    } catch (CustomException e) {
      System.out.println(e.getMessage());
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }

  public static Boolean checkLogin(UserRole userRole) {
    if (userRole.getUserRoleId() == null) {
      return Boolean.FALSE;
    } else {
      return Boolean.TRUE;
    }
  }
}
