package com.masai.servicelayer;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BookNotFound;
import com.masai.model.Book;
import com.masai.model.BookDTO;
import com.masai.repository.BookDAO;

@Service
public class BookServiceImpl implements BookService {
 
	
	@Autowired
	BookDAO repo;
	
	@Override
	public Book registerBook(Book b) throws BookNotFound {
		
		Book registeredproduct = repo.save(b);
		
		if(registeredproduct == null)
			throw new BookNotFound("Sorry unable to add book");
		else
			return registeredproduct;				
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFound {
		
		List<Book> list = repo.findAll();
		
		if(list.size()== 0)
			throw new BookNotFound("sorry no products");
		else
			return list;
		
		
	}

	@Override
	public Book updateBook(Integer id,Book b) throws BookNotFound {
		
		Optional<Book> optBook = repo.findById(id);
		
		
		if(optBook.isPresent()) {		
			return 	repo.save(b);
		}
		else
			throw new BookNotFound("Sorry unable to find book with id "+id );
		
	}

	@Override
	public Book deleteBookById(Integer pid) throws BookNotFound {
		
		Optional<Book> deletedB = repo.findById(pid);
		
		if(deletedB.isPresent()) {
			Book deleted = deletedB.get();
			repo.delete(deleted);
			
			return deleted;
		}
		else
			throw new BookNotFound("Sorry unable to delete book");
		
		
		
	}

	@Override
	public Book getBookById(Integer id) throws BookNotFound {
		
		Optional<Book> optBook = repo.findById(id);
		
		return optBook.orElseThrow( ()->new BookNotFound("No book by this id"));		
		
	}

	@Override
	public List<BookDTO> getAllBookDTO() throws BookNotFound {
		
		List<BookDTO> list = repo.findBookDTOall();
		
		if(list.size()== 0)
			throw new BookNotFound("sorry no products");
		else
			return list;
		
		
	}

	@Override
	public BookDTO findBookDTOById(Integer bId) throws BookNotFound {
		
		BookDTO b = repo.findBookDTObyId(bId);
		if(b!=null)
			return b;
		else
			throw new BookNotFound("no such book");
	}

	@Override
	public List<BookDTO> getAllBookDTOByName(String name) throws BookNotFound {
		List<BookDTO> list = repo.findBookByName(name);
		
		if(list.size()== 0)
			throw new BookNotFound("sorry no products");
		else
			return list;
	}

	


	
	
	
}
