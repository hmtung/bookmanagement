package service.impl;


import dao.impl.BookCaseDaoImpl;
import dao.impl.BookDaoImpl;
import dao.impl.ContainDaoImpl;
import model.Book;
import model.BookCase;
import model.Contain;
import model.User;
import service.BookCaseService;
import util.MessageUtil;
import util.ValidatorUtil;

import java.util.List;
import java.util.Scanner;

public class BookCaseServiceImpl implements BookCaseService {

    private BookCaseDaoImpl bookCaseDaoImpl;
    private BookDaoImpl bookDaoImpl;
    private ContainDaoImpl containDaoImpl;

    public BookCaseServiceImpl() {
        bookCaseDaoImpl = new BookCaseDaoImpl();
        bookDaoImpl = new BookDaoImpl();
        containDaoImpl = new ContainDaoImpl();
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

    public void viewBookCase(Integer user_id) {
        BookCase bookCase = bookCaseDaoImpl.viewBookCase(user_id);
        System.out.println(bookCase.toString());
        List<Contain> listContains = containDaoImpl.viewContain(bookCase.getBookCaseId());
        if (listContains.size() == 0) {
            System.out.println("Your BookCase is empty");
        } else {
            System.out.println("Your BookCase has " + listContains.size() + " books:");
            for (Contain i : listContains) {
                System.out.println(bookDaoImpl.getBookById(i.getBook().getBookId()).toString());
            }
        }

    }

}
