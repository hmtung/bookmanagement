package view;

import java.util.Scanner;

import service.impl.BookServiceImpl;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;
        int select;
        try {
            scanner = new Scanner(System.in);
            while (true) {
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

                        break;
                    case 2:

                        break;
                    case 3:
                    	BookServiceImpl bookServiceImpl = new BookServiceImpl();
                    	bookServiceImpl.viewListBook();
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
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
