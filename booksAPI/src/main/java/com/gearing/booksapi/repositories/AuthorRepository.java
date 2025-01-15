package com.gearing.booksapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gearing.booksapi.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	List<Author> findAll();
}
