package com.brendan.mybooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendan.mybooks.models.Book;
import com.brendan.mybooks.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
    private BookRepository bookRepository;

    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book book) {
    	System.out.println(book.getName());
        return bookRepository.save(book);
    }
    
    public Book editBook(Book book) {
    	return bookRepository.save(book);
    }
    
    
    public Book findById(Long id) {
    	Optional<Book> book = bookRepository.findById(id);
    	
    	if(book.isPresent()) {
    		return book.get();
    	} else {
    		return null;
    	}
    }
    
    public void delete(Long id) {
    	bookRepository.deleteById(id);
    }
    
}