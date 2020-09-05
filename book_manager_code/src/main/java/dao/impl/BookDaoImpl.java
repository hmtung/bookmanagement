package dao.impl;

import dao.BookDao;
import mapper.BookMapper;
import model.Book;
import util.Constants;

import java.util.List;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

  public List<Book> getAllBook() {
    StringBuffer query = new StringBuffer("SELECT * ");
    query.append("FROM " + Constants.BOOK_TABLE_NAME);
    List<Book> list = this.query(query.toString(), new BookMapper());
    return list;
  }

  public Book getBookById(Integer id) {
    StringBuffer query = new StringBuffer("SELECT * ");
    query.append(" FROM " + Constants.BOOK_TABLE_NAME);
    query.append(" WHERE book_id = ? ");
    List<Book> list = this.query(query.toString(), new BookMapper(), id);
    if (list.size() == 0) {
      return null;
    } else {
      return list.get(0);
    }
  }

  public Integer insertBook(Book book) {
    StringBuffer query = new StringBuffer("INSERT INTO  " + Constants.BOOK_TABLE_NAME + " ( ");
    query.append(" book_title, author, brief, publisher, content, category )");
    query.append(" VALUES(?, ?, ?, ?, ?,? )");
    Integer result = this.insert(query.toString(), book.getBookTitle(), book.getAuthor(),
        book.getBrief(), book.getPublisher(), book.getContent(), book.getCategory());
    return result;
  }

  public Integer updateBook(Book book) {
    StringBuffer query = new StringBuffer("UPDATE " + Constants.BOOK_TABLE_NAME);
    query.append(" SET book_title = ?");
    query.append(" WHERE book_id = ? ");
    Integer result = this.update(query.toString(), book.getBookTitle(), book.getBookId());
    return result;
  }

  public Integer deleteBook(Integer id) {
    StringBuffer query = new StringBuffer("DELETE FROM " + Constants.BOOK_TABLE_NAME);
    query.append(" WHERE book_id = ? ");
    Integer result = this.delete(query.toString(), id);
    return result;
  }
}
