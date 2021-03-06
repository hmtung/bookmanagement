package mapper;

import model.Book;
import model.BookCase;
import model.Contain;

import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc

/**
 * The Class ContainMapper.
 */
public class ContainMapper implements IRowMapper<Contain> {

    /**
     * {@inheritDoc}
     *
     * @see mapper.IRowMapper#mapRow(java.sql.ResultSet)
     */
    public Contain mapRow(ResultSet rs) {
        Contain contain = new Contain();
        Book book = new Book();
        try {
            book.setBookId(rs.getInt("book_id"));
        } catch (SQLException ex) {
            System.out.println("Converter BookCase:" + ex.getMessage());
            return null;
        }

        BookCase bookCase = new BookCase();
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
