package dao;

import java.util.List;

import model.Contain;

public interface ContainDao {
	List<Contain> viewContain(Integer book_case_id);
}
