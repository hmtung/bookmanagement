package model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class BookCase.
 */
public class BookCase implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The book case id. */
    private Integer bookCaseId;
    
    /** The book case name. */
    private String bookCaseName;

    /**
     * Instantiates a new book case.
     */
    public BookCase() {
    }

    /**
     * Instantiates a new book case.
     *
     * @param bookCaseId the book case id
     * @param bookCaseName the book case name
     */
    public BookCase(Integer bookCaseId, String bookCaseName) {
        this.bookCaseId = bookCaseId;
        this.bookCaseName = bookCaseName;
    }

    /**
     * Gets the book case id.
     *
     * @return the book case id
     */
    public Integer getBookCaseId() {
        return bookCaseId;
    }

    /**
     * Sets the book case id.
     *
     * @param bookCaseId the new book case id
     */
    public void setBookCaseId(Integer bookCaseId) {
        this.bookCaseId = bookCaseId;
    }

    /**
     * Gets the book case name.
     *
     * @return the book case name
     */
    public String getBookCaseName() {
        return bookCaseName;
    }

    /**
     * Sets the book case name.
     *
     * @param bookCaseName the new book case name
     */
    public void setBookCaseName(String bookCaseName) {
        this.bookCaseName = bookCaseName;
    }

    /**
     * {@inheritDoc}
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BookCase [bookCaseId=" + bookCaseId + ", bookCaseName=" + bookCaseName + "]";
    }
}
