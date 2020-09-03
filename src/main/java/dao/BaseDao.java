
package dao;

import java.util.List;

import mapper.IRowMapper;

public interface BaseDao<T> {
  public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);

  public void update(String sql, Object... parameters);

  public Long insert(String sql, Object... parameters);

  public Long delete(String sql, Object... parameters);
}
