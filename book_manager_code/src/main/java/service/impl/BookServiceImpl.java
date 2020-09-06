package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;

public class BookServiceImpl implements BookService {
	private BookDaoImpl bookDaoImpl;

	public BookServiceImpl() {
		bookDaoImpl = new BookDaoImpl();
	}

	public void searchBook(Scanner scanner) {
		List<Book> listBooks = new ArrayList<Book>();
		System.out.println("Please select search type:");
		System.out.println("1. By name");
		System.out.println("2. By author");
		System.out.println("3. By category");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1:
			System.out.print("Please enter book's name: ");
			String name = scanner.nextLine();
			listBooks = bookDaoImpl.searchBookByName(name);
			if (listBooks != null) {
				System.out.println("About " + listBooks.size() + " results");
				for (Book i : listBooks) {
					System.out.println(i.toString());
				}
			} else
				System.out.println("About 0 results");
			break;
		case 2:
			System.out.print("Please enter book's author: ");
			String author = scanner.nextLine();
			listBooks = bookDaoImpl.searchBookByAuthor(author);
			if (listBooks != null) {
				System.out.println("About " + listBooks.size() + " results");
				for (Book i : listBooks) {
					System.out.println(i.toString());
				}
			} else
				System.out.println("About 0 results");
			break;
		case 3:
			System.out.print("Please enter book's category: ");
			String category = scanner.nextLine();
			listBooks = bookDaoImpl.searchBookByCategory(category);
			if (listBooks != null) {
				System.out.println("About " + listBooks.size() + " results");
				for (Book i : listBooks) {
					System.out.println(i.toString());
				}
			} else
				System.out.println("About 0 results");
			break;
		default:
			break;
		}
	}

}
