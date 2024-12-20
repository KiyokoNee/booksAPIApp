package com.gearing.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gearing.booksapi.models.Book;
import com.gearing.booksapi.services.BookService;

@RestController
public class BooksAPI {
	private final BookService bookService;
	private final  String http = "/api/books";
	
	public BooksAPI(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping(http)
	public List<Book> index() {
		return bookService.allBooks();
	}
	
	@PostMapping(http)
	public Book create(@RequestParam String title, @RequestParam(value="description") String desc,
			@RequestParam(value="language") String lang, @RequestParam Integer pages) {
		return bookService.createBook(new Book(title, desc, lang, pages));
	}
	
	@GetMapping(http + "/{id}")
	public Book show(@PathVariable Long id) {
		return bookService.findBookById(id);
	}
	
	@PutMapping(http + "/{id}")
	public Book update(@PathVariable Long id, @RequestParam String title, @RequestParam(value = "description") String desc,
			@RequestParam(value="language") String lang, @RequestParam Integer pages) {
		
		return bookService.updateBook(id, title, desc, lang, pages);
	}
	
	@DeleteMapping(http + "/{id}")
	public void delete(@PathVariable Long id) {
		bookService.deleteBookById(id);
	}
}
