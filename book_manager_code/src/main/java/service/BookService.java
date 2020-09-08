package service;

import java.util.Scanner;

public interface BookService {
    int getNumOfBook();

    void viewListBook();

    void readBook(Scanner scanner);

    void deleteById(Scanner scanner);

    void updateContentBook(Scanner scanner);
    
    void insertBook(Scanner scanner);
    
    void searchBook(Scanner scanner);

}
