package com.masai.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.exceptions.BookNotFound;
import com.masai.model.Book;
import com.masai.servicelayer.BookService;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class AuthorController {

	@Autowired
	BookService bookService;

	/*we can add the class level CrossOrigin, to enable CORS on all handler 
	 * methods of this class.
	*/
	
	@GetMapping("/book")
	public  ResponseEntity<List<Book>> AllBooks() throws BookNotFound{

		List<Book> list = bookService.getAllBooks();
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/book/{id}")
	public ResponseEntity<Book> GetSpecificBook( @PathVariable("id") Integer ID) throws BookNotFound{
		
		Book b = bookService.getBookById(ID);
		
		return new ResponseEntity<>(b,HttpStatus.ACCEPTED);
	}
	
	//@CrossOrigin(origins = "http://127.0.0.1:5500/")
	@PostMapping(value= "/savebook")
	public ResponseEntity<Book>createBook(@Valid @RequestBody Book b) throws BookNotFound {
		
		Book added = bookService.registerBook(b);
		
		return new ResponseEntity<Book>(added,HttpStatus.ACCEPTED);
	}

	@PutMapping(value= "/updatebook/{id}")
	public ResponseEntity<Book> updateBook(@Valid @RequestBody Book b,
																  @PathVariable("id") Integer ID) 
			throws BookNotFound {
		
		Book updated = bookService.updateBook(ID,b);
		
		return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
	}
	

	@DeleteMapping(value= "/delete/{id}")
	public ResponseEntity<Book> deleteBook( @PathVariable("id") Integer ID) throws BookNotFound {
		
		Book updated = bookService.deleteBookById(ID);
		
		return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
	}
}
