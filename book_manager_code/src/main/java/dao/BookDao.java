package dao;

import model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBook();

    Book getBookById(Integer id);

    Integer insertBook(Book book);
    
}
