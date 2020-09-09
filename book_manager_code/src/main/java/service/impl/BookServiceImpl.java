package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import model.Book;
import service.BookService;
import util.MessageUtil;
import util.ValidatorUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public BookServiceImpl() {
        bookDao = new BookDaoImpl();
    }

    public int getNumOfBook() {
        int count = 0;
        for (Book book : bookDao.getAllBook()) {
            count++;
        }
        return count;
    }

    public void viewListBook() {
        int stt = 1;
        if (getNumOfBook() > 0) {
            System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s %8$-15s \n",
                    "STT", "bookId", "bookTitle", "Author", "Brief", "Publisher", "Content", "Category");
            for (Book book : bookDao.getAllBook()) {
                book.display(stt);
                stt++;
            }
        } else {
            System.out.println(MessageUtil.CHECK_BOOK);
        }
    }

    public void readBook(Scanner scanner) {
        int bookId = ValidatorUtil.inputInteger(MessageUtil.ENTER_BOOK_ID, scanner);
        if (bookDao.getBookById(bookId) == null) {
            System.out.println(MessageUtil.CHECK_NOT_EXIST_BOOK);
        } else {
            System.out.println(bookDao.getBookById(bookId).getBookTitle());
            System.out.println(bookDao.getBookById(bookId).getContent());
        }
    }

    public void deleteById(Scanner scanner) {
        int bookId = ValidatorUtil.inputInteger(MessageUtil.ENTER_BOOK_ID, scanner);
        try {
            int result = bookDao.deleteById(bookId);
            if (result >= 1) {
                System.out.println(MessageUtil.DELETE_BOOK_SUCCESS);
            } else {
                System.out.println(MessageUtil.DELETE_FAILED);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateContentBook(Scanner scanner) {
        int book_id = ValidatorUtil.inputInteger("Enter book_id: ", scanner);
        String content = ValidatorUtil.inputString("Enter content: ", scanner);
        Book book = new Book(book_id, content);
        Integer result = bookDao.editBook(book);
        if (result == 1)
            System.out.println("Update successful !");
        else
            System.out.println("Update failed !");
    }

    public void insertBook(Scanner scanner) {
        String title = ValidatorUtil.inputString("Enter the title: ", scanner);
        String author = ValidatorUtil.inputString("Enter the author: ", scanner);
        String category = ValidatorUtil.inputString("Enter the category: ", scanner);
        String brief = ValidatorUtil.inputString("Enter the brief: ", scanner);
        String publisher = ValidatorUtil.inputString("Enter the publisher: ", scanner);
        String content = ValidatorUtil.inputString("Enter the content: ", scanner);

        Book book = new Book(title, author, brief, publisher, content, category);
        Integer result = bookDao.insertBook(book);
        if (result == null) {
            System.out.println(MessageUtil.ADD_DATA_FAIL);
        } else {
            System.out.println(MessageUtil.ADD_DATA_SUCCESS);
        }
    }

    public void searchBook(Scanner scanner) {
        List<Book> listBooks = new ArrayList<Book>();
        System.out.println("Please select search type:");
        System.out.println("1. By name");
        System.out.println("2. By author");
        System.out.println("3. By category");
        int choice = ValidatorUtil.inputSelectedMenu(scanner);
        switch (choice) {
            case 1:
                System.out.print("Please enter book's name: ");
                String name = scanner.nextLine();
                listBooks = bookDao.searchBookByName(name);
                if (listBooks != null) {
                    System.out.println("About " + listBooks.size() + " results");
                    int stt = 1;
                    System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s %8$-15s \n",
                            "STT", "bookId", "bookTitle", "Author", "Brief", "Publisher", "Content", "Category");
                    for (Book book : listBooks) {
                        book.display(stt);
                        stt++;
                    }
                } else
                    System.out.println("About 0 results");
                break;
            case 2:
                System.out.print("Please enter book's author: ");
                String author = scanner.nextLine();
                listBooks = bookDao.searchBookByAuthor(author);
                if (listBooks != null) {
                    System.out.println("About " + listBooks.size() + " results");
                    int stt = 1;
                    System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s %8$-15s \n",
                            "STT", "bookId", "bookTitle", "Author", "Brief", "Publisher", "Content", "Category");
                    for (Book book : listBooks) {
                        book.display(stt);
                        stt++;
                    }
                } else
                    System.out.println("About 0 results");
                break;
            case 3:
                System.out.print("Please enter book's category: ");
                String category = scanner.nextLine();
                listBooks = bookDao.searchBookByCategory(category);
                if (listBooks != null) {
                    System.out.println("About " + listBooks.size() + " results");
                    int stt = 1;
                    System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s %5$-15s %6$-15s %7$-15s %8$-15s \n",
                            "STT", "bookId", "bookTitle", "Author", "Brief", "Publisher", "Content", "Category");
                    for (Book book : listBooks) {
                        book.display(stt);
                        stt++;
                    }
                } else
                    System.out.println("About 0 results");
                break;
            default:
                break;
        }
    }
}
