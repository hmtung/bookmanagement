package model;

import java.io.Serializable;

public class BookCase implements Serializable {
  private static final long serialVersionUID = 1L;
  private int bookCaseId;
  private String bookCaseName;

  public BookCase() {
  }

  public BookCase(int bookCaseId, String bookCaseName) {
    this.bookCaseId = bookCaseId;
    this.bookCaseName = bookCaseName;
  }

  public int getBookCaseId() {
    return bookCaseId;
  }

  public void setBookCaseId(int bookCaseId) {
    this.bookCaseId = bookCaseId;
  }

  public String getBookCaseName() {
    return bookCaseName;
  }

  public void setBookCaseName(String bookCaseName) {
    this.bookCaseName = bookCaseName;
  }
}
