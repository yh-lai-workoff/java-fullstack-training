package com.database.SpringBoot.repo;

import org.springframework.data.repository.CrudRepository;

import com.database.SpringBoot.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
}
