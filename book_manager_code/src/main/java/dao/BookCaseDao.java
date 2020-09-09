package dao;

import model.BookCase;

// TODO: Auto-generated Javadoc

/**
 * The Interface BookCaseDao.
 */
public interface BookCaseDao {

    /**
     * View book case.
     *
     * @param user_id the user id
     * @return the book case
     */
    BookCase viewBookCase(Integer user_id);

    /**
     * Adds the book to book case.
     *
     * @param bookId     the book id
     * @param bookCaseId the book case id
     * @return the integer
     */
    Integer addBookToBookCase(int bookId, int bookCaseId);

    /**
     * Removes the book from book case.
     *
     * @param bookId     the book id
     * @param bookCaseId the book case id
     * @return the integer
     */
    Integer removeBookFromBookCase(int bookId, int bookCaseId);

    /**
     * Clear book case.
     *
     * @param bookCaseId the book case id
     * @return the integer
     */
    Integer clearBookCase(int bookCaseId);
}
