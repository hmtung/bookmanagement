package dao;

import model.Contain;

import java.util.List;

public interface ContainDao {
    List<Contain> viewContain(Integer book_case_id);
}
