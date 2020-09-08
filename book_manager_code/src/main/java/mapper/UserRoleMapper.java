package mapper;

import java.sql.ResultSet;

import model.Role;
import model.User;
import model.UserRole;

public class UserRoleMapper implements IRowMapper<UserRole> {

  public UserRole mapRow(ResultSet rs) {
    UserRole userRole = new UserRole();
    User user = new User();
    Role role = new Role();
    try {
      userRole.setUserRoleId(rs.getInt("user_role_id"));
      try {
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
      } catch (Exception e) {
        System.out.println("Converter User:" + e.getMessage());
        return null;
      }

      userRole.setUser(user);
      try {
        role.setRoleId(rs.getInt("role_id"));
        role.setAuthority(rs.getString("authority"));
      } catch (Exception e) {
        System.out.println("Converter Role:" + e.getMessage());
        return null;
      }

      userRole.setRole(role);
    } catch (Exception e) {
      System.out.println("Converter User Role:" + e.getMessage());
      return null;
    }
    return userRole;
  }
}
