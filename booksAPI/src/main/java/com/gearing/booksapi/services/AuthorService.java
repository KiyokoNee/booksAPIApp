package com.gearing.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gearing.booksapi.models.Author;
import com.gearing.booksapi.repositories.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepo;
	
	// CRUD - retrieve all authors
	public List<Author> getAll() {
		return authorRepo.findAll();
	}
	
	// CRUD - create new author
	public void create(Author author) {
		authorRepo.save(author);
	}
	
	// CRUD - retrieve author by id
	public Author getById(Long id) {
		Optional<Author> optionalAuthor = authorRepo.findById(id);
		return optionalAuthor.isPresent() ? optionalAuthor.get() : null;
	}
	
	// CRUD - update author
	public void update(Author author) {
		authorRepo.save(author);
	}
	
	// CRUD - delete author by id
	public void deleteById(Long id) {
		Optional<Author> optionalAuthor = authorRepo.findById(id);
		if(optionalAuthor.isPresent())
			authorRepo.delete(optionalAuthor.get());
	}
}
