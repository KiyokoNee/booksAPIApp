package com.gearing.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gearing.booksapi.repositories.BookRepository;
import com.gearing.booksapi.models.Book;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// CRUD - retrieve all books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// CRUD - create new book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	// CRUD - retrieve book by id
	public Book findBookById(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent())
			return optionalBook.get();
		else 
			return null;
	}
	
	// CRUD - update book
	public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			Book book = optionalBook.get();
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(pages);
			
			return bookRepository.save(book);
		}
		else 
			return null;
	}
	
	// CRUD - delete book by id
	public void deleteBookById(Long id) {
		bookRepository.deleteById(id);
	}
	
	public List<Book> booksContaining(String search) {
		return bookRepository.findByDescriptionContaining(search);
	}
}
