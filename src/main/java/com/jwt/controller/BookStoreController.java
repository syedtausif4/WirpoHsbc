package com.jwt.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.BookStore;
import com.jwt.service.BookStoreService;

@RestController
public class BookStoreController {

	private static final Logger logger = Logger.getLogger(BookStoreController.class);

	@Autowired
	private BookStoreService BookStoreService;

	@RequestMapping(value = RestConstants.PATH_SEPARATOR, method = RequestMethod.GET)
	public ModelAndView listAllBooks(final ModelAndView model) throws IOException {
		final List<BookStore> bookStoreList = BookStoreService.getAllBooks();
		final BookStore bookStore = new BookStore();
		model.addObject(RestConstants.BOOK_STORE, bookStore);
		model.addObject(RestConstants.BOOK_STORE_LIST, bookStoreList);
		model.setViewName(RestConstants.HOME);
		return model;
	}

	@RequestMapping(value = RestConstants.NEW_BOOK, method = RequestMethod.GET)
	public ModelAndView newContact(final ModelAndView model) {
		final BookStore book = new BookStore();
		model.addObject(RestConstants.BOOK, book);
		model.setViewName(RestConstants.BOOK_FORM);
		return model;
	}

	@RequestMapping(value = RestConstants.SAVE_BOOK, method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute final BookStore book) {
		if (book.getId() == 0) {

			BookStoreService.addBook(book);
		} else {
			BookStoreService.updateBook(book);
		}

		return new ModelAndView(RestConstants.REDIRECT);
	}

	@RequestMapping(value = RestConstants.DELETE_BOOK, method = RequestMethod.GET)
	public ModelAndView deleteBook(final HttpServletRequest request) {
		final int bookId = Integer.parseInt(request.getParameter("id"));
		BookStoreService.deleteBook(bookId);
		return new ModelAndView(RestConstants.REDIRECT);
	}

	@RequestMapping(value = RestConstants.EDIT_BOOK, method = RequestMethod.GET)
	public ModelAndView editBook(final HttpServletRequest request) {
		final int bookId = Integer.parseInt(request.getParameter(RestConstants.ID));
		final BookStore book = BookStoreService.getBook(bookId);
		final ModelAndView model = new ModelAndView(RestConstants.BOOK_FORM);
		model.addObject(RestConstants.BOOK, book);

		return model;
	}

	@RequestMapping(value = "/home/{pageid}")
	public ModelAndView edit(@PathVariable int pageid) {
		final int total = 10;
		if (pageid == 1) {
		} else {
			pageid = ((pageid - 1) * total) + 1;
		}
		final List<BookStore> list = BookStoreService.getAllBooksByPage(pageid, total);

		return new ModelAndView("home", "list", list);
	}
}