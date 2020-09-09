package service.impl;

import dao.UserRoleDao;
import dao.impl.UserRoleDaoImpl;
import exception.UserNotFoundException;
import model.UserRole;
import service.UserService;
import util.Constants;
import util.MessageUtil;
import util.ValidatorUtil;

import java.util.Scanner;

public class UserServiceImpl implements UserService {

    private UserRoleDao userRoleDao;

    public UserServiceImpl() {
        userRoleDao = new UserRoleDaoImpl();
    }

    public void logOut() {
        Constants.USER_ROLE = new UserRole();
        System.out.println("------------Logout---------------");
    }

    public void checkLogin(Scanner scanner) {
        System.out
                .println("Welcome to Read Book Application. Please enter username and password!");
        do {
            try {
                String username = ValidatorUtil.inputString("Enter username: ", scanner);
                String password = ValidatorUtil.inputString("Enter password: ", scanner);
                UserRole userRole = userRoleDao.checkLogin(username, password);
                if (userRole == null) {
                    throw new UserNotFoundException(MessageUtil.LOGIN_FAIL);
                } else {
                    Constants.USER_ROLE = userRole;
                    break;
                }
            } catch (UserNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
