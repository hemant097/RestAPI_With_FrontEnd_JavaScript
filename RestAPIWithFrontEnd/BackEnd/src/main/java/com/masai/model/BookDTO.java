package com.masai.model;


public class BookDTO {	
	
	private Integer pages;	
	private Integer price;		
	private String name;			
	private String author;		
	private String publication;		
	private String category;

	public BookDTO(Integer pages, Integer price, String name, String author, String publication, String category) {
		this.pages = pages;
		this.price = price;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
	}
	public BookDTO() {}
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
	
	
	
}
