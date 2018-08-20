package com.jwt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKSTORE")
public class BookStore implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;

	@Column
	private String bookName;

	@Column
	private String author;

	@Column
	private Date releaseDate;
	
	
	@Column
	private String publisher;
	
	

	@Column
	private String collection;
	
	
	

	public int getId() {
		return bookId;
	}

	public void setId(int id) {
		this.bookId = id;
	}

	

	public String getRating() {
		return author;
	}

	public void setRating(String rating) {
		this.author = rating;
	}

	public String getDirectorName() {
		return publisher;
	}

	public void setDirectorName(String directorName) {
		this.publisher = directorName;
	}

	

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	

	
}