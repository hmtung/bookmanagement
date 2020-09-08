package util;

import java.util.Scanner;

import exception.CustomException;
import model.User;
import model.UserRole;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatorUtil.
 */
public class ValidatorUtil {
  
  /**
   * Input selected menu.
   *
   * @param scanner the scanner
   * @return the int
   */
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

  /**
   * Input integer.
   *
   * @param message the message
   * @param scanner the scanner
   * @return the int
   */
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

  /**
   * Input float.
   *
   * @param message the message
   * @param scanner the scanner
   * @return the float
   */
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

  /**
   * Input string.
   *
   * @param message the message
   * @param scanner the scanner
   * @return the string
   */
  public static String inputString(String message, Scanner scanner) {
    System.out.println(message);
    return scanner.nextLine();
  }

  /**
   * Check role admin.
   *
   * @param user the user
   * @return the boolean
   */
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

  /**
   * Check login.
   *
   * @param userRole the user role
   * @return the boolean
   */
  public static Boolean checkLogin(UserRole userRole) {
    if (userRole.getUserRoleId() == null) {
      return Boolean.FALSE;
    } else {
      return Boolean.TRUE;
    }
  }
}
