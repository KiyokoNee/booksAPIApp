package com.gearing.booksapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gearing.booksapi.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// retrieve all books from database
	List<Book> findAll(); 
	
	// find books with descriptions containing search string
	List<Book> findByDescriptionContaining(String search);
	
	// count how many titles contain a given string
	Long countByTitleContaining(String search);
	
	// deletes a book that starts with a specific title
	Long deleteByTitleStartingWith(String search);
}
