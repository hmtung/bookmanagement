
package untils;

import java.util.Scanner;

public class ValidatorUntil {
  public static int inputSelectdMenu(Scanner scanner) {
    int selected;
    do {
      try {
        System.out.print("Please choice one option: ");
        selected = Integer.parseInt(scanner.nextLine());
        break;
      } catch (Exception e) {
        System.out.println(MessageUntils.SELECTED_MENU_ERROR_MESSAGE);
      }
    } while (true);
    return selected;
  }

  public static int inputInterge(String message, Scanner scanner) {
    int input;
    do {
      try {
        System.out.println(message);
        input = Integer.parseInt(scanner.nextLine());
        break;
      } catch (Exception e) {
        System.out.println(MessageUntils.WRONG_FORMAT);
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
        System.out.println(MessageUntils.WRONG_FORMAT);
      }
    } while (true);
    return input;
  }

  public static String inputString(String message, Scanner scanner) {
    System.out.println(message);
    return scanner.nextLine();
  }

}
