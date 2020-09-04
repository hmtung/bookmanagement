package model;

import java.io.Serializable;
import java.util.Date;

public class Contain implements Serializable {
    private static final long serialVersionUID = 1L;
    private BookCase bookCase;
    private Book book;
    private Date createDate;

    public Contain() {
    }

    public Contain(BookCase bookCase, Book book, Date createDate) {
        this.bookCase = bookCase;
        this.book = book;
        this.createDate = createDate;
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
