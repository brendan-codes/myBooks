package com.brendan.mybooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brendan.mybooks.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    // this method retrieves all the books from the database
    List<Book> findAll();
    
    @Query(value="SELECT * FROM book WHERE lenght=?1", nativeQuery=true)
    public List<Book> getBooksFromAuthorId(Long id);
    
}