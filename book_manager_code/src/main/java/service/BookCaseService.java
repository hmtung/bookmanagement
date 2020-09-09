package service;


import model.User;

import java.util.Scanner;

// TODO: Auto-generated Javadoc

/**
 * The Interface BookCaseService.
 */
public interface BookCaseService {

    /**
     * View book case.
     *
     * @param user_id the user id
     */
    void viewBookCase(Integer user_id);

    /**
     * Adds the book to book case.
     *
     * @param scanner the scanner
     * @param user    the user
     */
    void addBookToBookCase(Scanner scanner, User user);

    /**
     * Removes the book from book case.
     *
     * @param scanner the scanner
     * @param user    the user
     */
    void removeBookFromBookCase(Scanner scanner, User user);

    /**
     * Clear book case.
     *
     * @param user the user
     */
    void clearBookCase(User user);

    /**
     * Edits the book case.
     *
     * @param scanner the scanner
     * @param user    the user
     */
    void editBookCase(Scanner scanner, User user);
}
