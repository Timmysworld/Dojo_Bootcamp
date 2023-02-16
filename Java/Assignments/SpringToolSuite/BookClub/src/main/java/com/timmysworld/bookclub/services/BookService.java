package com.timmysworld.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.timmysworld.bookclub.models.Book;
import com.timmysworld.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	//CREATE: ADD BOOK WITH EXTRA VALIDATIONS
	public Book addbook(Book newBook, BindingResult result) {
		
		Optional<Book> b = bookRepo.findByTitle(newBook.getTitle());
		
		if(b.isPresent()) {
			result.rejectValue("title", "title", "That Book already exist.");
//			return null;
		}
		
		if(result.hasErrors()) {
			return null;
		}
		return bookRepo.save(newBook);
	}
	
	//READ: FIND BOOK BY ID
	public Book findBook(Long id) {
		Optional<Book> b = bookRepo.findById(id);
		if(b.isPresent()) {
			return b.get();
		}else {
			return null;
		}
		
	}
	//UPDATE: SENDS NEW INFORMATION TO DATABASE
	public Book updateBook(Book books) {
		return bookRepo.save(books);
	}
	
	 //DELETE BOOK
    public void deleteBook(Long id) {
		Optional<Book> b = bookRepo.findById(id);
		if(b.isPresent()) {
			bookRepo.deleteById(id);
		}
	}
	
}// END BOOK SERVICE


