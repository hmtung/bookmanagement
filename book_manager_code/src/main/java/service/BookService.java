package service;

import java.util.Scanner;

public interface BookService {
    //----------View List Book-----------//
    int getNumOfBook();

    void viewListBook();

    void readBook(Scanner scanner);

    //----------------------------------//
    void deleteById(Scanner scanner);

    void editBookService(Scanner scanner);
}
