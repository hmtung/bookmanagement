package service;


import model.User;

import java.util.Scanner;

public interface BookCaseService {
    void viewBookCase(Integer user_id);

    void addBookToBookCase(Scanner scanner, User user);

    void removeBookFromBookCase(Scanner scanner, User user);

    void clearBookCase(User user);
}
