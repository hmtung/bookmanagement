package model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc

/**
 * The Class User.
 */
public class User implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The id.
     */
    private Integer id;

    /**
     * The username.
     */
    private String username;

    /**
     * The password.
     */
    private String password;

    /**
     * The book case.
     */
    private BookCase bookCase;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Instantiates a new user.
     *
     * @param username the username
     * @param password the password
     */
    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new user.
     *
     * @param id       the id
     * @param username the username
     * @param password the password
     * @param bookCase the book case
     */
    public User(Integer id, String username, String password, BookCase bookCase) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bookCase = bookCase;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the book case.
     *
     * @return the book case
     */
    public BookCase getBookCase() {
        return bookCase;
    }

    /**
     * Sets the book case.
     *
     * @param bookCase the new book case
     */
    public void setBookCase(BookCase bookCase) {
        this.bookCase = bookCase;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", bookCase=" + bookCase + "]";
    }

}
