
package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

public class BookMapper implements IRowMapper<Book> {

  public Book mapRow(ResultSet rs) {
    Book book = new Book();
    try {
      book.setBookId(rs.getInt(0));
      book.setBookTitle(rs.getString(1));
      book.setAuthor(rs.getString(2));
      book.setBrief(rs.getString(3));
      book.setPublisher(rs.getString(4));
      book.setContent(rs.getString(5));
      book.setCategory(rs.getString(6));
    } catch (SQLException ex) {
      System.out.println("Converter ThanhVien:" + ex.getMessage());
      return null;
    }
    return book;
  }

}
