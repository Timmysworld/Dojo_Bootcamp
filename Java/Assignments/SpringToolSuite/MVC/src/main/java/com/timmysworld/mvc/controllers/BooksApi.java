package com.timmysworld.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.timmysworld.mvc.models.Book;
import com.timmysworld.mvc.services.BookService;

@RestController
public class BooksApi {
	//tells us that we are going to be using a BookService
    private final BookService bookService;
    
    // Dependency injection to make available in the controller
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    @GetMapping("/api/books")
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @PostMapping(value="/api/books")
    public Book create(
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
    	// CREATES NEW BOOK
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }
    
    @GetMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }
    
    @PutMapping("/api/books/{id}")
    public Book update(
    		@PathVariable("id")Long id,
    		@RequestParam(value="title") String title, 
    		@RequestParam(value="description") String desc, 
    		@RequestParam(value="language") String lang, 
    		@RequestParam(value="pages") Integer numOfPages) {
    	
    	// create a new Book object with the values we passed in
    	Book book = new Book(title, desc, lang, numOfPages);
    	
    	//UPDATES BOOK
    	book.setId(id);
        Book updateBook = bookService.updateBook(book);
        return updateBook;
    }
    
    @DeleteMapping(value="/api/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
