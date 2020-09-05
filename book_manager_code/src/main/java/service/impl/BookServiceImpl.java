
package service.impl;

import java.util.Scanner;

import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;
import util.MessageUtil;
import util.ValidatorUtil;

public class BookServiceImpl implements BookService {

  private BookDaoImpl bookDaoImpl;

  public BookServiceImpl() {
    bookDaoImpl = new BookDaoImpl();
  }

  public void insertBook(Scanner scanner) {
    String title = ValidatorUtil.inputString("Enter the title: ", scanner);
    String author = ValidatorUtil.inputString("Enter the author: ", scanner);
    String category = ValidatorUtil.inputString("Enter the category: ", scanner);
    String brief = ValidatorUtil.inputString("Enter the brief: ", scanner);
    String publisher = ValidatorUtil.inputString("Enter the publisher: ", scanner);
    String content = ValidatorUtil.inputString("Enter the content: ", scanner);

    Book book = new Book(title, author, brief, publisher, content, category);
    Integer result = bookDaoImpl.insertBook(book);
    if (result == null) {
      System.out.println(MessageUtil.ADD_DATA_FAIL);
    } else {
      System.out.println(MessageUtil.ADD_DATA_SUCCESS);
    }
  }

}
