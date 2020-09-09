package model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc

/**
 * The Class UserRole.
 */
public class UserRole implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The user role id.
     */
    private Integer userRoleId;

    /**
     * The user.
     */
    private User user;

    /**
     * The role.
     */
    private Role role;

    /**
     * Instantiates a new user role.
     */
    public UserRole() {
    }

    /**
     * Instantiates a new user role.
     *
     * @param userRoleId the user role id
     * @param user       the user
     * @param role       the role
     */
    public UserRole(Integer userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    /**
     * Gets the user role id.
     *
     * @return the user role id
     */
    public Integer getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets the user role id.
     *
     * @param userRoleId the new user role id
     */
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user.
     *
     * @param user the new user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserRole [userRoleId=" + userRoleId + ", user=" + user + ", role=" + role + "]";
    }

}
