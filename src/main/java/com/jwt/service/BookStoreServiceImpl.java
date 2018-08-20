package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.BookStoreDAO;
import com.jwt.model.BookStore;

@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService {

	@Autowired
	private BookStoreDAO bookDAO;

	@Override
	@Transactional
	public void addBook(BookStore book) {
		bookDAO.addBook(book);
	}

	@Override
	@Transactional
	public List<BookStore> getAllBooks() {
		return bookDAO.getAllBooks();
	}
	
	@Override
	@Transactional
	public List<BookStore> getAllBooksByPage(int pageid, int total) {
		return bookDAO.getAllBooks();
	}

	@Override
	@Transactional
	public void deleteBook(Integer bookId) {
		bookDAO.deleteBook(bookId);
	}

	public BookStore getBook(int bookId) {
		return bookDAO.getBook(bookId);
	}

	public BookStore updateBook(BookStore book) {
		// TODO Auto-generated method stub
		return bookDAO.updateBook(book);
	}

	

}
