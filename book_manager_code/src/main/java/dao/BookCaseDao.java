package dao;


public interface BookCaseDao {
    Integer addBookToBookCase(int bookId, int bookCaseId);

    Integer removeBookFromBookCase(int bookId, int bookCaseId);

    Integer clearBookCase(int bookCaseId);
}
