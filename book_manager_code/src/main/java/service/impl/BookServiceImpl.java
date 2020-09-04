package service.impl;


import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

import java.sql.SQLException;

public class BookServiceImpl implements BookService {

    public int deleteById(Integer id) {
        BookDao bookDao = new BookDaoImpl();
        int result = 0;
        try {
            result = bookDao.deleteById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //return 1 if delete success, 0 if fail
        return result;
    }
}
