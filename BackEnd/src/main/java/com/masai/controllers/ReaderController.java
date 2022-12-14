package com.masai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.BookNotFound;

import com.masai.model.BookDTO;
import com.masai.servicelayer.BookService;
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RequestMapping("/reader")
public class ReaderController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/book")
	private  ResponseEntity<List<BookDTO>> AllBooks() throws BookNotFound{

		List<BookDTO> list = bookService.getAllBookDTO();
		
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/book/{id}")
	private ResponseEntity<BookDTO> GetSpecificBook( @PathVariable("id") Integer ID) throws BookNotFound{
		
		BookDTO b = bookService.findBookDTOById(ID);
		
		return new ResponseEntity<>(b,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/book/find/{name}")
	private ResponseEntity<List<BookDTO>> SearchBooks( @PathVariable("name") String name) throws BookNotFound{
		
		List<BookDTO> list = bookService.getAllBookDTOByName(name);
		System.out.println(name);
		return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
	}
	
	
}
