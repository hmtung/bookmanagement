package model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private BookCase bookCase;

	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(Integer id, String username, String password, BookCase bookCase) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.bookCase = bookCase;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", bookCase=" + bookCase + "]";
	}

}
