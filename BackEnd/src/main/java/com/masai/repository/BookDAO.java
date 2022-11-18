package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Book;
import com.masai.model.BookDTO;
@Repository
public interface BookDAO extends JpaRepository<Book, Integer> {
	
	//Integer pages, Integer price, String name, String author,
	//String publication, String category
	
	@Query(value = "select new com.masai.model.BookDTO(b.pages,"
			+ "b.price,b.name,b.author,b.publication,b.category) from Book b")
	public List<BookDTO> findBookDTOall();
	
	@Query(value = "select new com.masai.model.BookDTO(b.pages,"
			+ "b.price,b.name,b.author,b.publication,b.category) from Book b "
			+ "where b.name like %?1% or b.author like %?1%" )
	public List<BookDTO> findBookByName(String name);
	
	
	@Query(value = "select new com.masai.model.BookDTO(b.pages,"
			+ "b.price,b.name,b.author,b.publication,b.category) from Book b "
			+ "where b.bookid=?1")
	public BookDTO findBookDTObyId(Integer id);
	
	
}
