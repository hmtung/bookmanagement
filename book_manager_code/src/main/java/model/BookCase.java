package model;

import java.io.Serializable;

public class BookCase implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bookCaseId;
    private String bookCaseName;

    public BookCase() {
    }

    public BookCase(Integer bookCaseId, String bookCaseName) {
        this.bookCaseId = bookCaseId;
        this.bookCaseName = bookCaseName;
    }

    public Integer getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(Integer bookCaseId) {
        this.bookCaseId = bookCaseId;
    }

    public String getBookCaseName() {
        return bookCaseName;
    }

    public void setBookCaseName(String bookCaseName) {
        this.bookCaseName = bookCaseName;
    }
}
