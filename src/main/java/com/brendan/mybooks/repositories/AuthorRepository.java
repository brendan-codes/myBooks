package com.brendan.mybooks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.brendan.mybooks.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    List<Author> findAll();
    
    @Query(value="SELECT * FROM author WHERE book_id=?1",nativeQuery=true)
    public List<Author> findAuthorsOfBook(Long id);
}
