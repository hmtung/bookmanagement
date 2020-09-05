package view;

import java.util.Scanner;

import service.impl.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;
        int select;
        try {
            scanner = new Scanner(System.in);
            while (true) {
            	System.out.println("======= READING BOOK MANAGEMENT SYSTEM =======");
                System.out.println("1. Login");
                System.out.println("2. Logout");
                System.out.println("3. View list book");
                System.out.println("4. View book detail");
                System.out.println("5. Search book");
                System.out.println("6. View bookcase");
                System.out.println("7. Edit bookcase");
                System.out.println("8. Create book");
                System.out.println("9. Update book");
                System.out.println("10. Delete book");
                System.out.println("11. Exit");
                
                System.out.println("============================");

                System.out.print("=> Choose: ");
                select = scanner.nextInt();
                scanner.nextLine();

                switch (select) {
                    case 1:
                    		UserServiceImpl userServiceImpl = new UserServiceImpl();
                    		userServiceImpl.checkLogin();
                        break;
                    case 2:
                    	UserServiceImpl impl = new UserServiceImpl();
                		impl.logOut();
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                    	break;
                    case 7:
                    	break;
                    case 8:
                    	break;
                    case 9:
                    	break;
                    case 10:
                    	break;
                    case 11:
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
