package dao;

import java.util.List;

import model.Book;

public interface BookDao {
  public List<Book> getAllBook();

  public Book getBookById(String id);
}
