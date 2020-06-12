package com.brendan.mybooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brendan.mybooks.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
    List<Author> findAll();
}
