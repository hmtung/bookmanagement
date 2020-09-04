
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

public class BookMapper implements IRowMapper<Book> {

  public Book mapRow(ResultSet rs) {
    Book book = new Book();
    try {
      book.setBookId(rs.getInt(1));
      book.setBookTitle(rs.getString(2));
      book.setAuthor(rs.getString(3));
      book.setBrief(rs.getString(4));
      book.setPublisher(rs.getString(5));
      book.setContent(rs.getString(6));
      book.setCategory(rs.getString(7));
    } catch (SQLException ex) {
      System.out.println("Converter Book:" + ex.getMessage());
      return null;
    }
    return book;
  }

}
