package com.jwt.service;

import java.util.List;

import com.jwt.model.BookStore;

public interface BookStoreService {
	
	public void addBook(BookStore book);

	public List<BookStore> getAllBooks();
	public List<BookStore> getAllBooksByPage(int pageid, int total);

	public void deleteBook(Integer bookId);

	public BookStore getBook(int bookId);

	public BookStore updateBook(BookStore book);
}
