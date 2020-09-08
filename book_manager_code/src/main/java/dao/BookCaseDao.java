package dao;

import model.BookCase;

public interface BookCaseDao {
	BookCase viewBookCase(Integer user_id);
    Integer addBookToBookCase(int bookId, int bookCaseId);

    Integer removeBookFromBookCase(int bookId, int bookCaseId);

    Integer clearBookCase(int bookCaseId);
}
