package dao.impl;


import dao.BookCaseDao;
import mapper.BookCaseMapper;
import model.BookCase;
import util.Constants;

import java.sql.Timestamp;
import java.util.List;


// TODO: Auto-generated Javadoc

/**
 * The Class BookCaseDaoImpl.
 */
public class BookCaseDaoImpl extends BaseDaoImpl<BookCase> implements BookCaseDao {

    /**
     * {@inheritDoc}
     *
     * @see dao.BookCaseDao#viewBookCase(java.lang.Integer)
     */
    public BookCase viewBookCase(Integer user_id) {
        StringBuffer query = new StringBuffer("SELECT * \n");
        query.append("FROM " + Constants.BOOK_CASE_TABLE_NAME + "\n");
        query.append("WHERE  user_id = ?");
        List<BookCase> list = this.query(query.toString(), new BookCaseMapper(), user_id);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see dao.BookCaseDao#addBookToBookCase(int, int)
     */
    public Integer addBookToBookCase(int bookId, int bookCaseId) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO " + Constants.CONTAIN_TABLE_NAME + "(");
        query.append(" book_case_id, book_id, create_date )");
        query.append(" VALUES(?,?,?)");
        return this.insert(query.toString(), bookCaseId, bookId, new Timestamp(System.currentTimeMillis()));
    }

    /**
     * {@inheritDoc}
     *
     * @see dao.BookCaseDao#removeBookFromBookCase(int, int)
     */
    public Integer removeBookFromBookCase(int bookId, int bookCaseId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + Constants.CONTAIN_TABLE_NAME);
        query.append(" WHERE book_case_id = ?");
        query.append(" AND book_id = ?");
        return this.delete(query.toString(), bookCaseId, bookId);
    }

    /**
     * {@inheritDoc}
     *
     * @see dao.BookCaseDao#clearBookCase(int)
     */
    public Integer clearBookCase(int bookCaseId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + Constants.CONTAIN_TABLE_NAME);
        query.append(" WHERE book_case_id = ?");
        return this.delete(query.toString(), bookCaseId);
    }
}
