package service;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Interface BookService.
 */
public interface BookService {
    
    /**
     * Gets the num of book.
     *
     * @return the num of book
     */
    int getNumOfBook();

    /**
     * View list book.
     */
    void viewListBook();

    /**
     * Read book.
     *
     * @param scanner the scanner
     */
    void readBook(Scanner scanner);

    /**
     * Delete by id.
     *
     * @param scanner the scanner
     */
    void deleteById(Scanner scanner);

    /**
     * Update content book.
     *
     * @param scanner the scanner
     */
    void updateContentBook(Scanner scanner);
    
    /**
     * Insert book.
     *
     * @param scanner the scanner
     */
    void insertBook(Scanner scanner);
    
    /**
     * Search book.
     *
     * @param scanner the scanner
     */
    void searchBook(Scanner scanner);

}
