package com.masai.servicelayer;

import java.util.List;

import com.masai.exceptions.BookNotFound;
import com.masai.model.Book;
import com.masai.model.BookDTO;

public interface BookService {

	
	public Book registerBook(Book b) throws BookNotFound;
	
	public List<Book> getAllBooks() throws BookNotFound;
	
	public Book updateBook(Integer id,Book b) throws BookNotFound;
	
	public Book deleteBookById(Integer pid) throws BookNotFound;
	
	public Book getBookById(Integer id) throws BookNotFound;
	
	public List<BookDTO> getAllBookDTO() throws BookNotFound;
	
	public BookDTO findBookDTOById(Integer bId) throws BookNotFound;
	
}
