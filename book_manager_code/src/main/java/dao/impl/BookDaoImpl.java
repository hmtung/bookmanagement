package dao.impl;

import java.util.List;

import dao.BookDao;
import mapper.BookMapper;
import model.Book;
import util.Constants;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

  /**
   * {@inheritDoc}
   * 
   * @see dao.BookDao#getAllBook()
   */
  public List<Book> getAllBook() {
    StringBuffer query = new StringBuffer("SELECT *");
    query.append("FROM " + Constants.BOOK_TABLE_NAME);
    List<Book> list = this.query(query.toString(), new BookMapper());
    return list;
  }

  /**
   * {@inheritDoc}
   * 
   * @see dao.BookDao#getBookById(java.lang.String)
   */
  public Book getBookById(String id) {
    StringBuffer query = new StringBuffer("SELECT *");
    query.append("FROM " + Constants.BOOK_TABLE_NAME);
    query.append("WHERE book_id = ? ");
    List<Book> list = this.query(query.toString(), new BookMapper(), id);
    if (list.size() == 0) {
      return null;
    } else {
      return list.get(0);
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see dao.BookDao#insertBook(model.Book)
   */
  public Integer insertBook(Book book) {
    StringBuffer query = new StringBuffer("INSERT INTO  " + Constants.BOOK_TABLE_NAME);
    query.append("VALUES()");

    return null;
  }
}
