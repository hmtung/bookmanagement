package dao.impl;

import dao.BookCaseDao;
import model.BookCase;
import util.Constants;

import java.sql.Timestamp;
import java.util.Date;


public class BookCaseDaoImpl extends BaseDaoImpl<BookCase> implements BookCaseDao {

    public Integer addBookToBookCase(int bookId, int bookCaseId) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO " + Constants.CONTAIN_TABLE_NAME + "(");
        query.append(" book_case_id, book_id, create_date )");
        query.append(" VALUES(?,?,?)");
        return this.insert(query.toString(), bookCaseId, bookId, new Timestamp(System.currentTimeMillis()));
    }

    public Integer removeBookFromBookCase(int bookId, int bookCaseId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + Constants.CONTAIN_TABLE_NAME);
        query.append(" WHERE book_case_id = ?");
        query.append(" AND book_id = ?");
        return this.delete(query.toString(), bookCaseId, bookId);
    }

    public Integer clearBookCase(int bookCaseId) {
        StringBuffer query = new StringBuffer();
        query.append("DELETE FROM " + Constants.CONTAIN_TABLE_NAME);
        query.append(" WHERE book_case_id = ?");
        return this.delete(query.toString(), bookCaseId);
    }
}
