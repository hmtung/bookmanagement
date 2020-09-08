package dao.impl;

import dao.BookDao;
import mapper.BookMapper;
import model.Book;
import util.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BookDaoImpl.
 */
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

    /**
     * {@inheritDoc}
     *
     * @see dao.BookDao#getAllBook()
     */
    public List<Book> getAllBook() {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.BOOK_TABLE_NAME);
        List<Book> list = this.query(query.toString(), new BookMapper());
        return list;
    }

    /**
     * {@inheritDoc}
     * @see dao.BookDao#getBookById(java.lang.Integer)
     */
    public Book getBookById(Integer id) {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.BOOK_TABLE_NAME + "\n");
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
      StringBuffer query = new StringBuffer("INSERT INTO  " + Constants.BOOK_TABLE_NAME + " ( ");
      query.append(" book_title, author, brief, publisher, content, category )");
      query.append(" VALUES(?, ?, ?, ?, ?,? )");
      Integer result = this.insert(query.toString(), book.getBookTitle(), book.getAuthor(),
          book.getBrief(), book.getPublisher(), book.getContent(), book.getCategory());
      return result;
    }

    /**
     * {@inheritDoc}
     *
     * @see dao.BookDao#searchBookByName
     */
    public List<Book> searchBookByName(String name) {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.BOOK_TABLE_NAME + "\n");
        query.append("WHERE book_title LIKE ?");
        String name1 = '%' + name + '%';
        List<Book> list = this.query(query.toString(), new BookMapper(), name1);

        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see dao.BookDao#searchBookByAuthor
     */
    public List<Book> searchBookByAuthor(String author) {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.BOOK_TABLE_NAME + "\n");
        query.append("WHERE author LIKE ?");
        String author1 = '%' + author + '%';
        List<Book> list = this.query(query.toString(), new BookMapper(), author1);
        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see dao.BookDao#searchBookByCategory
     */
    public List<Book> searchBookByCategory(String category) {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.BOOK_TABLE_NAME + "\n");
        query.append("WHERE category LIKE ?");
        String category1 = '%' + category + '%';
        List<Book> list = this.query(query.toString(), new BookMapper(), category1);
        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * {@inheritDoc}
     * @see dao.BookDao#deleteById(java.lang.Integer)
     */
    public int deleteById(Integer id) throws SQLException {
        String query = "DELETE FROM " + Constants.BOOK_TABLE_NAME + " WHERE book_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    /**
     * {@inheritDoc}
     * @see dao.BookDao#editBook(model.Book)
     */
    public Integer editBook(Book book) {
        StringBuffer querry = new StringBuffer("UPDATE " + Constants.BOOK_TABLE_NAME + "\n");
        querry.append("SET content = ?\n");
        querry.append("WHERE book_id = ?\n");
        Integer result = this.update(querry.toString(), book.getContent(), book.getBookId());
        return result;
    }
}
