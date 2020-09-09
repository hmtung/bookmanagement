package dao;

import model.Contain;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface ContainDao.
 */
public interface ContainDao {

    /**
     * View contain.
     *
     * @param book_case_id the book case id
     * @return the list
     */
    List<Contain> viewContain(Integer book_case_id);
}
