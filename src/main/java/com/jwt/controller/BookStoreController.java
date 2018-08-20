package com.jwt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
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

	private static final Logger logger = Logger
			.getLogger(BookStoreController.class);

	public BookStoreController() {
		System.out.println("BookStoreController()");
	}

	@Autowired
	private BookStoreService BookStoreService;
	

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView listAllBooks(ModelAndView model) throws IOException {
		List<BookStore> bookStoreList = BookStoreService.getAllBooks();
		BookStore bookStore = new BookStore();
		model.addObject("bookStore", bookStore);
		model.addObject("bookStoreList", bookStoreList);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newBook", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		BookStore book = new BookStore();
		model.addObject("book", book);
		model.setViewName("BookForm");
		return model;
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute BookStore book ) {
		if (book.getId() == 0) { 
	            
	            
			
			BookStoreService.addBook(book);
		} else 
			BookStoreService.updateBook(book);
		
		return new ModelAndView("redirect:/");
		//return new ModelAndView("home");
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		BookStoreService.deleteBook(bookId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public ModelAndView editBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		BookStore book = BookStoreService.getBook(bookId);
		ModelAndView model = new ModelAndView("BookForm");
		model.addObject("book", book);

		return model;
	}

	@RequestMapping(value="/home/{pageid}")  
    public ModelAndView edit(@PathVariable int pageid){  
        int total=10;  
        if(pageid==1){}  
        else{  
            pageid=(pageid-1)*total+1;  
        }  
        List<BookStore> list = BookStoreService.getAllBooksByPage(pageid,total);  
       
        
        return new ModelAndView("home","list",list);  
    }  
}