package com.database.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.database.SpringBoot.entities.Book;
import com.database.SpringBoot.services.BookService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class BookController {
	
	@Autowired
	private BookService bs;
	
	
	@GetMapping("/allBooks")
	public List<Book> allBooksMethod(){
		return bs.getAllBooks();
	}
	
	@GetMapping("/allBooks/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bs.getBookById(id);
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b) {
		return bs.addBook(b);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bs.deleteBookById(id);
		return "Deleted";
	}
	
	@PutMapping("/editBook/{id}")
	public Book editBook(@PathVariable("id") int id, @RequestBody Book b) {
		bs.editBookById(id, b);
		return null;
	}
}
