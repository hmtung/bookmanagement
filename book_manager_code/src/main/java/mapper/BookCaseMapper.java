package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.BookCase;

public class BookCaseMapper implements IRowMapper<BookCase>{

	public BookCase mapRow(ResultSet rs) {
		BookCase bookCase = new BookCase();
		try {
			bookCase.setBookCaseId(rs.getInt(1));
			bookCase.setBookCaseName(rs.getString(2));
		} catch (SQLException ex) {
			 System.out.println("Converter BookCase:" + ex.getMessage());
	         return null;
		}
		return bookCase;
	}
}
