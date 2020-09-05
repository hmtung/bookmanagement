package dao;

import model.User;

public interface UserDao {
	User checkLogin(String name, String pass);
}
