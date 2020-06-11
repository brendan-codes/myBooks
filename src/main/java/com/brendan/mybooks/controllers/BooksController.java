package com.brendan.mybooks.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brendan.mybooks.models.Book;
import com.brendan.mybooks.services.BookService;

@RestController
public class BooksController {
	private BookService bookService;
	
    public BooksController(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping("/api/books")
    public List<Book> index() {
    	List<Book> booksFromService = bookService.allBooks();
    	System.out.println(booksFromService.toString());
        return booksFromService;
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="name") String name) {
    	System.out.println(name);
        Book book = new Book(name);
        System.out.println(book);
        return bookService.createBook(book);
    }
}
