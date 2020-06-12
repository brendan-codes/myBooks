package com.brendan.mybooks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brendan.mybooks.models.Author;
import com.brendan.mybooks.models.Book;
import com.brendan.mybooks.models.Library;
import com.brendan.mybooks.repositories.AuthorRepository;
import com.brendan.mybooks.repositories.BookRepository;
import com.brendan.mybooks.repositories.LibraryRepository;

@Service
public class ApiService {

	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private LibraryRepository libraryRepo;
	
	@Autowired
	private AuthorRepository authorRepo;

    
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
    
    
    public Book findBookById(Long id) {
    	Optional<Book> book = bookRepository.findById(id);
    	
    	if(book.isPresent()) {
    		return book.get();
    	} else {
    		return null;
    	}
    }
    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    
    
    
	public Library createLibrary(Library library) {
		return libraryRepo.save(library);
	}
	
	public List<Library> allLibraries(){
		return libraryRepo.findAll();
	}
	
	public Library findLibraryById(Long id) {
		Optional<Library> library = libraryRepo.findById(id);
		
		if(library.isPresent()) {
			return library.get();
		} else {
			return null;
		}
	}
	
   public void deleteLibrary(Long id) {
    	libraryRepo.deleteById(id);
    }
    
   
    
    
	public Author createAuthor(Author author) {
		return authorRepo.save(author);
	}
	
	public List<Author> allAuthors(){
		return authorRepo.findAll();
	}
	
	public Author findAuthorById(Long id) {
		Optional<Author> author = authorRepo.findById(id);
		
		if(author.isPresent()) {
			return author.get();
		} else {
			return null;
		}
	}
	
    public void deleteAuthor(Long id) {
    	authorRepo.deleteById(id);
    }
    
    
    
}