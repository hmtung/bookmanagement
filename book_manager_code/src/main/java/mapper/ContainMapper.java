package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;
import model.BookCase;
import model.Contain;

public class ContainMapper implements IRowMapper<Contain> {

	public Contain mapRow(ResultSet rs) {
		Contain contain = new Contain();
		Book book = new Book();
		BookCase bookCase = new BookCase();

		try {
			book.setBookId(rs.getInt("book_id"));
		} catch (SQLException ex) {
			System.out.println("Converter BookCase:" + ex.getMessage());
			return null;
		}

		try {
			bookCase.setBookCaseId(rs.getInt("book_case_id"));
		} catch (SQLException ex) {
			System.out.println("Converter BookCase:" + ex.getMessage());
			return null;
		}

		try {
			contain.setBook(book);
			contain.setBookCase(bookCase);
			contain.setCreateDate(rs.getDate("create_date"));
		} catch (SQLException ex) {
			System.out.println("Converter BookCase:" + ex.getMessage());
			return null;
		}
		return contain;
	}
}
