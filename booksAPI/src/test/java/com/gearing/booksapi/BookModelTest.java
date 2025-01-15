package com.gearing.booksapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gearing.booksapi.controllers.BookController;
import com.gearing.booksapi.models.Author;
import com.gearing.booksapi.models.Book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class BookModelTest {
	@Autowired
	private BookController controller;
	private static Validator validator;
	
	@BeforeAll
	static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void validController() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	void createBook() {
		Book book = new Book();
		book.setTitle("Dragon Rider");
		book.setDescription("Great Book");
		book.setLanguage("English");
		book.setNumberOfPages(529);
		Set<ConstraintViolation<Book>> violations = validator.validate(book);
		for(ConstraintViolation<Book> violation: violations) {
			System.out.println(violation.getMessage());
		}
		
		assertTrue(violations.isEmpty());
	}
	
	@Test
	void assumeTitleIsNull() {
	    Book book = new Book();
	    book.setDescription("Great Book");
	    book.setLanguage("English");
	    book.setNumberOfPages(734);
	    Set<ConstraintViolation<Book>> violations = validator.validate(book);
	    assertFalse(violations.isEmpty());
	}

	@Test
	void createAuthor() {
		Author author = new Author();
		
		// Only set up two properties to make it easier to verify
		author.setFirstName("John");
		author.setLastName("Doe");
		
		Set<ConstraintViolation<Author>> violations = validator.validate(author);
		for(ConstraintViolation<Author> violation: violations) {
			System.out.println(violation.getMessage());
		}
		
		assertTrue(violations.isEmpty());
	}
}
