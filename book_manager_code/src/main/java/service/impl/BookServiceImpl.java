package service.impl;


import java.util.Scanner;

import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;
import util.ValidatorUtil;

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
        int stt = 1;
        if(getNumOfBook() > 0) {
            System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s %8$-15s \n",
                    "STT", "bookId", "bookTitle", "Author","Brief","Publisher","Content","Category");
            for(Book book : bookDao.getAllBook()) {
                book.display(stt);
                stt++;
            }
        }
        else {
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
        else System.out.println("Update failed !");
    }
}
