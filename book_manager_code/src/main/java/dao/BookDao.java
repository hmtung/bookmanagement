package dao;

import model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook();

  public Book getBookById(Integer id);

    Integer insertBook(Book book);

  public Integer updateBook(Book book);

  public Integer deleteBook(Integer id);
}
