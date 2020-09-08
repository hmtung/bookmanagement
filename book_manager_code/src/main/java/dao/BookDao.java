package dao;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> getAllBook();

    Book getBookById(Integer id);

    Integer insertBook(Book book);
    
    Integer editBook(Book book);


    int deleteById(Integer id) throws SQLException;

}
