package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Book{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookid;
	
	@Min(value = 74, message = "Book pages cannot be less than 75")
	private Integer pages;
	
	@Max(value = 2500, message = "Book price must be less than 2500")
	private Integer price;
	
	@Size(min=6 , message = "book name must be more than 6 characters")
	private String name;
	
	
	@Size(min=4 , message = "author name must be more than 4 characters")
	private String author;
		
	@Size(min=7 , message = "publication name must be more than 7 characters")
	private String publication;
	
	@Size(min=5 , message = "category name must be more than 5 characters")
	private String category;
	
	@Size(min=4 , max = 4, message = "author number must be equal to 4 characters")
	private String author_no;
	

	
	public Integer getBookid() {
		return bookid;
	}



	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}



	public Integer getPages() {
		return pages;
	}



	public void setPages(Integer pages) {
		this.pages = pages;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getPublication() {
		return publication;
	}



	public void setPublication(String publication) {
		this.publication = publication;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getAuthor_no() {
		return author_no;
	}



	public void setAuthor_no(String author_no) {
		this.author_no = author_no;
	}



	public Book(){}

	public Book(Integer bookid, Integer pages, Integer price, String name, String author,
			String publication, String category, String author_no) {
		this.bookid = bookid;
		this.pages = pages;
		this.price = price;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.author_no = author_no;
	}
	
	
}
