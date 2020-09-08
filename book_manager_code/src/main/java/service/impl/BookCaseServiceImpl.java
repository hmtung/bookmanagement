package service.impl;

import java.util.List;

import dao.BookCaseDao;
import dao.impl.BookCaseDaoImpl;
import dao.impl.BookDaoImpl;
import dao.impl.ContainDaoImpl;
import model.BookCase;
import model.Contain;
import service.BookCaseService;

public class BookCaseServiceImpl implements BookCaseService {
	private BookDaoImpl bookDaoImpl;
	private BookCaseDaoImpl bookCaseDaoImpl;
	private ContainDaoImpl containDaoImpl;

	public BookCaseServiceImpl() {
		bookDaoImpl = new BookDaoImpl();
		bookCaseDaoImpl = new BookCaseDaoImpl();
		containDaoImpl = new ContainDaoImpl();
	}

	public void viewBookCase(Integer user_id) {
		BookCase bookCase = bookCaseDaoImpl.viewBookCase(user_id);
		System.out.println(bookCase.toString());
		List<Contain> listContains = containDaoImpl.viewContain(bookCase.getBookCaseId());
		if (listContains.size() == 0) {
			System.out.println("Your BookCase is empty");
		} else {
			System.out.println("Your BookCase has " + listContains.size() + " books:");
			for (Contain i : listContains) {
				System.out.println(bookDaoImpl.getBookById(i.getBook().getBookId()).toString());
			}
		}

	}
}
