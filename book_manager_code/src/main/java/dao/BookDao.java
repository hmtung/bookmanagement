package dao;

import model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook();

    Book getBookById(String id);

    Integer insertBook(Book book);
}
