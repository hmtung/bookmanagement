package dao;

import java.util.List;

import model.Book;

public interface BookDao {
  public List<Book> getAllBook();

  public Book getBookById(Integer id);

  public Integer insertBook(Book book);

  public Integer updateBook(Book book);

  public Integer deleteBook(Integer id);
}
