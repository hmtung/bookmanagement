package dao;

import mapper.IRowMapper;

import java.util.List;

public interface BaseDao<T> {
    List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);

    Integer update(String sql, Object... parameters);

    Integer insert(String sql, Object... parameters);

  	Integer delete(String sql, Object... parameters);
  
}
