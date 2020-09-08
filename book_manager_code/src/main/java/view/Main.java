package view;

import model.BookCase;
import model.User;
import service.impl.BookCaseServiceImpl;

import java.util.Scanner;

import com.sun.org.apache.xml.internal.security.Init;

import service.BookCaseService;
import service.impl.BookCaseServiceImpl;

public class Main {
	
	public static BookCaseService bookCaseService;
	
	public static void init() {
		bookCaseService = new BookCaseServiceImpl();
	}
	
	
    public static void main(String[] args) {
    	init();
        Scanner scanner = null;
        int select;

        try {
            scanner = new Scanner(System.in);
            while (true) {
                System.out.println("======= READING BOOK MANAGEMENT SYSTEM =======");
                System.out.println("1. Login");
                System.out.println("2. Display book case");
                System.out.println("3. ");
                System.out.println("4. ");
                System.out.println("5. ");
                System.out.println("6. Exit");
                System.out.println("============================");

                System.out.print("=> Choose: ");
                select = scanner.nextInt();
                scanner.nextLine();

                switch (select) {
                    case 1:

                        break;
                    case 2:
                    	bookCaseService.viewBookCase(1);
                        break;
                    case 3:

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
