
package dao;

import java.util.List;

import mapper.IRowMapper;

public interface BaseDao<T> {
  public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);

  public Integer update(String sql, Object... parameters);

  public Integer insert(String sql, Object... parameters);

  public Integer delete(String sql, Object... parameters);
}
