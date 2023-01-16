package com.database.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.SpringBoot.entities.Book;
import com.database.SpringBoot.repo.BookRepository;

@Service
public class BookService  {
	@Autowired
	private BookRepository br;
	
	public List<Book> getAllBooks(){
		List<Book> bookList = (List<Book>) br.findAll();
		return bookList;
	}
	
	public Book getBookById(int id) {
		return br.findById(id).get();
	}
	
	public Book editBookById(int id, Book b) {
		Book old = br.findById(id).get();
		old.setAuthor(b.getAuthor());
		old.setTitle(b.getTitle());
		
		return br.save(old);
	}
	
	public Book addBook(Book b) {
		br.save(b);
		return b;
	}
	
	public void deleteBookById(int id) {
		br.deleteById(id);
	}
}
