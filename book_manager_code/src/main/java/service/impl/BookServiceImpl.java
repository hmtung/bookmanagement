package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;
import util.MessageUtil;
import util.ValidatorUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
	public int getNumOfBook() {
		BookDao bookDao = new BookDaoImpl();
		int count = 0;
		for (Book book : bookDao.getAllBook()) {
			count++;
		}
		return count;
	}

	public void viewListBook() {
		BookDao bookDao = new BookDaoImpl();
		if (getNumOfBook() > 0) {
			for (Book book : bookDao.getAllBook()) {
				System.out.println(book.toString());
			}
		} else {
			System.out.println(MessageUtil.CHECK_BOOK);
		}
	}

	public void readBook(Scanner scanner) {
		BookDao bookDao = new BookDaoImpl();
		int bookId = ValidatorUtil.inputInteger(MessageUtil.ENTER_BOOK_ID, scanner);
		if (bookDao.getBookById(bookId) == null) {
			System.out.println(MessageUtil.CHECK_NOT_EXIST_BOOK);
		} else {
			System.out.println(bookDao.getBookById(bookId).getBookTitle());
			System.out.println(bookDao.getBookById(bookId).getContent());
		}
	}

	public void deleteById(Scanner scanner) {
		BookDao bookDao = new BookDaoImpl();
		int bookId = ValidatorUtil.inputInteger(MessageUtil.ENTER_BOOK_ID, scanner);
		try {
			int result = bookDao.deleteById(bookId);
			if (result >= 1) {
				System.out.println(MessageUtil.DELETE_BOOK_SUCCESS);
			} else {
				System.out.println(MessageUtil.DELETE_FAILED);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

}
