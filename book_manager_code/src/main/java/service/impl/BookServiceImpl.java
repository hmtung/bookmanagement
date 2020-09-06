package service.impl;

import java.util.Scanner;

import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;
import util.ValidatorUtil;

public class BookServiceImpl implements BookService{

	public void editBookService(Scanner scanner) {
		System.out.println("------Edit Book------");
		
		int book_id = ValidatorUtil.inputInteger("Enter book_id: ", scanner);
		String book_title = ValidatorUtil.inputString("Enter book_title: ", scanner);
		String author = ValidatorUtil.inputString("Enter author: ", scanner);
		String brief = ValidatorUtil.inputString("Enter brief: ", scanner);
		String publisher = ValidatorUtil.inputString("Enter publisher: ", scanner);
		String content = ValidatorUtil.inputString("Enter content: ", scanner);
		String category = ValidatorUtil.inputString("Enter category: ", scanner);
		
		Book book = new Book(book_id, book_title, author, brief, publisher, content, category);
		BookDaoImpl bd = new BookDaoImpl();
		
		Integer result = bd.editBook(book);
		if (result==1) System.out.println("Update successful !");
		if (result==0) System.out.println("Querry wrong !");
		if (result==-1) System.out.println("Update failed !");
	}

}
