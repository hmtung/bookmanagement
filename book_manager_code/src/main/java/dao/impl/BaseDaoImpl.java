package dao.impl;

import dao.BaseDao;
import mapper.IRowMapper;
import util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseDaoImpl.
 *
 * @param <T>
 *          the generic type
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

  /** The connection. */
  protected static Connection connection;

  /**
   * Instantiates a new base dao impl.
   */
  public BaseDaoImpl() {
    if (connection == null) {
      try {
        connection = new JDBCConnection().getConnection();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see dao.BaseDao#query(java.lang.String, mapper.IRowMapper,
   *      java.lang.Object[])
   */
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
      return null;
    } finally {
      closeFunction(statement, resultSet);
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see dao.BaseDao#update(java.lang.String, java.lang.Object[])
   */
  public Integer update(String sql, Object... parameters) {
    Integer result = null;
    PreparedStatement statement = null;
    try {
      statement = connection.prepareStatement(sql);
      setParameter(statement, parameters);
      result = statement.executeUpdate();
      return result;
    } catch (SQLException e) {
      return null;
    } finally {
      closePreparedStatement(statement);
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see dao.BaseDao#insert(java.lang.String, java.lang.Object[])
   */
  public Integer insert(String sql, Object... parameters) {
    Integer id = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      setParameter(statement, parameters);
      statement.executeUpdate();
      resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        id = resultSet.getInt(1);
      }
      return id;
    } catch (SQLException e) {
      return null;
    } finally {
      closeFunction(statement, resultSet);
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see dao.BaseDao#delete(java.lang.String, java.lang.Object[])
   */
  public Integer delete(String sql, Object... parameters) {
    Integer id = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      setParameter(statement, parameters);
      statement.executeUpdate();
      resultSet = statement.getGeneratedKeys();
      if (resultSet.next()) {
        id = resultSet.getInt(1);
      }
      return id;
    } catch (SQLException e) {
      return null;
    } finally {
      closeFunction(statement, resultSet);
    }
  }

  /**
   * Sets the parameter.
   *
   * @param statement
   *          the statement
   * @param parameters
   *          the parameters
   */
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

  /**
   * Check login.
   *
   * @param sql
   *          the sql
   * @param nameI
   *          the name I
   * @param passI
   *          the pass I
   * @param parameters
   *          the parameters
   * @return true, if successful
   */
  public boolean checkLogin(String sql, String nameI, String passI, Object... parameters) {
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    boolean check = false;
    try {
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      setParameter(statement, parameters);
      resultSet = statement.executeQuery();
      if (resultSet.next()) {
        if (nameI.equals(resultSet.getString(1)) && passI.equals(resultSet.getString(2))) {
          check = true;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      check = false;
    }
    return check;

  }

  /**
   * Close function.
   *
   * @param ps
   *          the ps
   * @param rs
   *          the rs
   */
  public void closeFunction(PreparedStatement ps, ResultSet rs) {
    try {
      if (ps != null) {
        ps.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Close prepared statement.
   *
   * @param ps
   *          the ps
   */
  public void closePreparedStatement(PreparedStatement ps) {
    try {
      if (ps != null) {
        ps.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
