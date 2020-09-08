package mapper;

import model.BookCase;

import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class BookCaseMapper.
 */
public class BookCaseMapper implements IRowMapper<BookCase> {

    /**
     * {@inheritDoc}
     * @see mapper.IRowMapper#mapRow(java.sql.ResultSet)
     */
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
