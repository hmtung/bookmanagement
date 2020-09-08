package dao.impl;


import java.util.List;

import dao.BookCaseDao;
import mapper.BookCaseMapper;
import model.BookCase;
import util.Constants;

import java.sql.Timestamp;
import java.util.Date;


public class BookCaseDaoImpl extends BaseDaoImpl<BookCase> implements BookCaseDao {

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
