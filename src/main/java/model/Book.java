package model;

import java.io.Serializable;

public class Book implements Serializable {
  private static final long serialVersionUID = 1L;
  private int bookId;
  private String bookTitle;
  private String author;
  private String brief;
  private String publisher;
  private String content;
  private String category;

  public Book() {
  }

  public Book(int bookId, String bookTitle, String author, String brief, String publisher,
      String content, String category) {
    this.bookId = bookId;
    this.bookTitle = bookTitle;
    this.author = author;
    this.brief = brief;
    this.publisher = publisher;
    this.content = content;
    this.category = category;
  }

  public int getBookId() {
    return bookId;
  }

  public void setBookId(int bookId) {
    this.bookId = bookId;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
