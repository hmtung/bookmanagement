package dao;

import java.util.Scanner;

import model.User;

public interface UserDao {
	User checkLogin(String name, String pass,Scanner scanner);
}
