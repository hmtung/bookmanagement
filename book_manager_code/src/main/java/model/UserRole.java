package model;

import java.io.Serializable;

public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userRoleId;
    private User user;
    private Role role;

    public UserRole() {
    }

    public UserRole(Integer userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
