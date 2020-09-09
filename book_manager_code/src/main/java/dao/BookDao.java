package dao;

import model.Book;

import java.sql.SQLException;
import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface BookDao.
 */
public interface BookDao {

    /**
     * Gets the all book.
     *
     * @return the all book
     */
    List<Book> getAllBook();

    /**
     * Gets the book by id.
     *
     * @param id the id
     * @return the book by id
     */
    Book getBookById(Integer id);

    /**
     * Insert book.
     *
     * @param book the book
     * @return the integer
     */
    Integer insertBook(Book book);

    /**
     * Search book by name.
     *
     * @param name the name
     * @return the list
     */
    List<Book> searchBookByName(String name);

    /**
     * Search book by author.
     *
     * @param author the author
     * @return the list
     */
    List<Book> searchBookByAuthor(String author);

    /**
     * Search book by category.
     *
     * @param category the category
     * @return the list
     */
    List<Book> searchBookByCategory(String category);

    /**
     * Edits the book.
     *
     * @param book the book
     * @return the integer
     */
    Integer editBook(Book book);

    /**
     * Delete by id.
     *
     * @param id the id
     * @return the int
     * @throws SQLException the SQL exception
     */
    int deleteById(Integer id) throws SQLException;

}
