package com.jwt.dao;

import java.util.List;
import com.jwt.model.BookStore;

public interface BookStoreDAO {

	public void addBook(BookStore book);

	public List<BookStore> getAllBooks();
	
	public List<BookStore> getAllBooksByPage(int pageid, int total);

	public void deleteBook(Integer bookId);

	public BookStore updateBook(BookStore book);

	public BookStore getBook(int bookId);
}
