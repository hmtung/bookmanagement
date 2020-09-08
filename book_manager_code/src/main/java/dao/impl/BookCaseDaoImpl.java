package dao.impl;


import java.util.List;

import dao.BookCaseDao;
import mapper.BookCaseMapper;
import model.BookCase;
import util.Constants;

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
}
