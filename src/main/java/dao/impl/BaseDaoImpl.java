
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import mapper.IRowMapper;
import util.JDBCConnection;

public class BaseDaoImpl<T> implements BaseDao<T> {

  private Connection connection;

  public BaseDaoImpl() {
    if (connection == null) {
      try {
        connection = new JDBCConnection().getConnection();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<T> list = new ArrayList<T>();
    try {
      statement = connection.prepareStatement(sql);
      setParameter(statement, parameters);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        T t = rowMapper.mapRow(resultSet);
        list.add(t);
      }
      return list;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  public void update(String sql, Object... parameters) {
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(sql);
      setParameter(statement, parameters);
      statement.executeUpdate();
    } catch (SQLException e) {

    }
  }

  public Long insert(String sql, Object... parameters) {
    Long id = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      setParameter(statement, parameters);
      statement.executeUpdate();
      resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        id = resultSet.getLong(1);
      }
      return id;
    } catch (SQLException e) {
      return null;
    }
  }

  public Long delete(String sql, Object... parameters) {
    Long id = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      setParameter(statement, parameters);
      statement.executeUpdate();
      resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        id = resultSet.getLong(1);
      }
      return id;
    } catch (SQLException e) {

      return null;
    }
  }

  public void setParameter(PreparedStatement statement, Object... parameters) {
    try {
      for (int i = 0; i < parameters.length; i++) {
        int index = i + 1;
        Object element = parameters[i];
        if (element instanceof Long) {
          statement.setLong(index, (Long) element);
        } else if (element instanceof String) {
          statement.setString(index, (String) element);
        } else if (element instanceof Integer) {
          statement.setInt(index, (Integer) element);
        } else if (element instanceof Timestamp) {
          statement.setTimestamp(index, (Timestamp) element);
        }
      }
    } catch (SQLException e) {
      return;
    }
  }

}
