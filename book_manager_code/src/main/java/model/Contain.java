package model;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class Contain.
 */
public class Contain implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The book case.
     */
    private BookCase bookCase;

    /**
     * The book.
     */
    private Book book;

    /**
     * The create date.
     */
    private Date createDate;

    /**
     * Instantiates a new contain.
     */
    public Contain() {
    }

    /**
     * Instantiates a new contain.
     *
     * @param bookCase   the book case
     * @param book       the book
     * @param createDate the create date
     */
    public Contain(BookCase bookCase, Book book, Date createDate) {
        this.bookCase = bookCase;
        this.book = book;
        this.createDate = createDate;
    }

    /**
     * Gets the book case.
     *
     * @return the book case
     */
    public BookCase getBookCase() {
        return bookCase;
    }

    /**
     * Sets the book case.
     *
     * @param bookCase the new book case
     */
    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    /**
     * Gets the book.
     *
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book.
     *
     * @param book the new book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the creates the date.
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets the creates the date.
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
