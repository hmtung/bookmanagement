package service.impl;

import java.util.List;

import dao.impl.BookCaseDaoImpl;
import dao.impl.BookDaoImpl;
import dao.impl.ContainDaoImpl;
import model.BookCase;
import model.Contain;
import service.BookCaseService;
import util.MessageUtil;

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
		List<Contain> listContains = containDaoImpl.viewContain(bookCase.getBookCaseId());
		if (listContains.isEmpty()) {
			System.out.println(MessageUtil.BOOK_CASE_IS_EMPTY);
		} else {
			System.out.println("Your BookCase has " + listContains.size() + " books:");
			for (Contain i : listContains) {
				System.out.println(bookDaoImpl.getBookById(i.getBook().getBookId()).toString());
			}
		}

	}
}
