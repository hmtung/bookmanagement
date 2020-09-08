package dao;

import mapper.IRowMapper;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface BaseDao.
 *
 * @param <T> the generic type
 */
public interface BaseDao<T> {
    
    /**
     * Query.
     *
     * @param sql the sql
     * @param rowMapper the row mapper
     * @param parameters the parameters
     * @return the list
     */
    List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);

    /**
     * Update.
     *
     * @param sql the sql
     * @param parameters the parameters
     * @return the integer
     */
    Integer update(String sql, Object... parameters);

    /**
     * Insert.
     *
     * @param sql the sql
     * @param parameters the parameters
     * @return the integer
     */
    Integer insert(String sql, Object... parameters);

    /**
     * Delete.
     *
     * @param sql the sql
     * @param parameters the parameters
     * @return the integer
     */
    Integer delete(String sql, Object... parameters);

}
