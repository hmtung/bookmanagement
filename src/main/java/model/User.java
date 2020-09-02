package model;

import java.io.Serializable;


public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private BookCase bookCase;

    public User() {
    }

    public User(int id, String username, String password, BookCase bookCase) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bookCase = bookCase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BookCase getBookCase() {
        return bookCase;
    }

    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }
}
