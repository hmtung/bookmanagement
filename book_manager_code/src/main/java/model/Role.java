package model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc

/**
 * The Class Role.
 */
public class Role implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The role id.
     */
    private Integer roleId;

    /**
     * The authority.
     */
    private String authority;

    /**
     * Instantiates a new role.
     */
    public Role() {
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the authority.
     *
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the authority.
     *
     * @param authority the new authority
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * {@inheritDoc}
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Role [roleId=" + roleId + ", authority=" + authority + "]";
    }

}
