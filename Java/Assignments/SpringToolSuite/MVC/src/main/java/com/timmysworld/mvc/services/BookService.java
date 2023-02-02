package com.timmysworld.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.timmysworld.mvc.models.Book;
import com.timmysworld.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book from 3 methods {findBook, isPresent, get} 
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //UPDATE BOOK
    	// updateBook will take in a Book object and save it to our database
    	// repository will automatically update an existing Book object if their IDs match
    public Book updateBook(Book book) {
    	return bookRepository.save(book);
    }
    
    //DELETE BOOK
    public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
}
