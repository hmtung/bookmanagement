package mapper;

import java.sql.ResultSet;

// TODO: Auto-generated Javadoc
/**
 * The Interface IRowMapper.
 *
 * @param <T> the generic type
 */
public interface IRowMapper<T> {
    
    /**
     * Map row.
     *
     * @param rs the rs
     * @return the t
     */
    T mapRow(ResultSet rs);
}
