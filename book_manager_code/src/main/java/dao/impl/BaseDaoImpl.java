package dao.impl;

import dao.BaseDao;
import mapper.IRowMapper;
import util.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    protected static Connection connection;

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
            return null;
        } finally {
            closeFunction(statement, resultSet);
        }
    }

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

    
    public boolean checkLogin(String sql,String nameI, String passI, Object... parameters) {
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
    	boolean check = false;
    	try {
    		statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		setParameter(statement, parameters);
    		resultSet =statement.executeQuery();
    		if(resultSet.next()) {
    			if(nameI.equals(resultSet.getString(1))  && passI.equals(resultSet.getString(2)))
    			{
    				check = true;
    			}
    		}
    	}catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;
    	
    }
    
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
