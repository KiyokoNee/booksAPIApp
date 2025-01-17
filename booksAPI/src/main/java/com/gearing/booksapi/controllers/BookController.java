package com.gearing.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gearing.booksapi.models.Book;
import com.gearing.booksapi.services.AuthorService;
import com.gearing.booksapi.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookservice;
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/books")
	public String showAllBooks(Model model) {
		List<Book> books = bookservice.allBooks();
		
		model.addAttribute("books", books);
		
		return "index.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String showBookById(@PathVariable Long id, Model model) {
		Book book = bookservice.findBookById(id);
		
		model.addAttribute("book", book);
		
		return "show.jsp";
	}
}
