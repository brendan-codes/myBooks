package com.brendan.mybooks.services;

import java.util.List;

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
}