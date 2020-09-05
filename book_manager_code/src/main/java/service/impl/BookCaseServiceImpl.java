package service.impl;


import dao.impl.BookCaseDaoImpl;
import dao.impl.BookDaoImpl;
import model.Book;
import model.User;
import service.BookCaseService;
import util.MessageUtil;
import util.ValidatorUtil;

import java.util.Scanner;

public class BookCaseServiceImpl implements BookCaseService {

    private BookCaseDaoImpl bookCaseDaoImpl;
    private BookDaoImpl bookDaoImpl;

    public BookCaseServiceImpl() {
        bookCaseDaoImpl = new BookCaseDaoImpl();
        bookDaoImpl = new BookDaoImpl();
    }

    public void addBookToBookCase(Scanner scanner, User user) {
        int bookId = ValidatorUtil.inputInteger("Please enter the book id: ", scanner);
        Book book = bookDaoImpl.getBookById(bookId);
        if (book == null){
            System.out.println(MessageUtil.BOOK_NOT_FOUND);
            return;
        }
        Integer result = bookCaseDaoImpl.addBookToBookCase(book.getBookId(), user.getBookCase().getBookCaseId());
        if (result == null){
            System.out.println(MessageUtil.ADD_DATA_FAIL);
        }else{
            System.out.println(MessageUtil.ADD_DATA_SUCCESS);
        }
    }

    public void removeBookFromBookCase(Scanner scanner, User user) {
        int bookId = ValidatorUtil.inputInteger("Please enter the book id: ", scanner);
        Book book = bookDaoImpl.getBookById(bookId);
        if (book == null){
            System.out.println(MessageUtil.BOOK_NOT_FOUND);
            return;
        }
        Integer result = bookCaseDaoImpl.removeBookFromBookCase(book.getBookId(), user.getBookCase().getBookCaseId());
        if (result == null){
            System.out.println(MessageUtil.REMOVE_DATA_FAIL);
        }else{
            System.out.println(MessageUtil.REMOVE_DATA_SUCCESS);
        }
    }

    public void clearBookCase(User user) {
        Integer result = bookCaseDaoImpl.clearBookCase(user.getBookCase().getBookCaseId());
        if (result == null){
            System.out.println(MessageUtil.REMOVE_DATA_FAIL);
        }else{
            System.out.println(MessageUtil.REMOVE_DATA_SUCCESS);
            System.out.println("Your bookcase is empty!");
        }
    }

}
