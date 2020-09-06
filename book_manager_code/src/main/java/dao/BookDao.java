package dao;

import model.Book;

import java.util.List;

public interface BookDao {
	List<Book> getAllBook();

	Book getBookById(Integer id);

	Integer insertBook(Book book);

	List<Book> searchBookByName(String name);

	List<Book> searchBookByAuthor(String author);

	List<Book> searchBookByCategory(String category);

}
