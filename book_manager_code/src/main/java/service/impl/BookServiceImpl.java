package service.impl;

import java.sql.SQLException;
import java.util.Scanner;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;
import util.MessageUtil;
import util.ValidatorUtil;

public class BookServiceImpl implements BookService{

	public int getNumOfBook() {
		BookDao bookDao = new BookDaoImpl();
		int count = 0;
		for(Book book : bookDao.getAllBook()) {
			count++;
		}
		return count;
	}
	
	public void viewListBook() {
		BookDao bookDao = new BookDaoImpl();
		if(getNumOfBook() > 0) {
			for(Book book : bookDao.getAllBook()) {
				System.out.println(book.toString());
			}
		}
		else {
			System.out.println(MessageUtil.CHECK_BOOK);
		}
	}
	
	public void readBook(Scanner scanner) {
		BookDao bookDao = new BookDaoImpl();
		String bookId = ValidatorUtil.inputString(MessageUtil.ENTER_BOOK_ID, scanner);
		if(bookDao.getBookById(bookId)==null) {
			System.out.println(MessageUtil.CHECK_NOT_EXIST_BOOK);
		}
		else {
			System.out.println(bookDao.getBookById(bookId).getBookTitle());
			System.out.println(bookDao.getBookById(bookId).getContent());
		}
	}
	
	
  
}
