package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.BookStore;

@Repository
public class BookStoreDAOImpl implements BookStoreDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addBook(BookStore book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);

	}

	@SuppressWarnings("unchecked")
	public List<BookStore> getAllBooks() {

		return sessionFactory.getCurrentSession().createQuery("from BOOKSTORE").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<BookStore> getAllBooksByPage(int pageid, int total) {

		return sessionFactory.getCurrentSession().createQuery("from BOOKSTORE").list();
	}

	@Override
	public void deleteBook(Integer bookId) {
		BookStore book = (BookStore) sessionFactory.getCurrentSession().load(
				BookStore.class, bookId);
		if (null != book) {
			this.sessionFactory.getCurrentSession().delete(book);
		}

	}

	public BookStore getBook(int empid) {
		return (BookStore) sessionFactory.getCurrentSession().get(
				BookStore.class, empid);
	}

	@Override
	public BookStore updateBook(BookStore book) {
		sessionFactory.getCurrentSession().update(book);
		return book;
	}

	

}