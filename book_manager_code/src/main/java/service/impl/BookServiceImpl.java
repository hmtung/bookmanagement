package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;
import util.MessageUtil;
import util.ValidatorUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class BookServiceImpl implements BookService {
    public void deleteById(Scanner scanner) {
        BookDao bookDao = new BookDaoImpl();
        int bookId = ValidatorUtil.inputInteger(MessageUtil.ENTER_BOOK_ID,scanner);
        try {
            int result = bookDao.deleteById(bookId);
            if(result>=1){
                System.out.println(MessageUtil.DELETE_BOOK_SUCCESS);
            }
            else{
                System.out.println(MessageUtil.DELETE_FAILED);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
