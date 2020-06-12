package com.brendan.mybooks.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brendan.mybooks.models.Library;

@Repository
public interface LibraryRepository extends CrudRepository<Library, Long>{
	List<Library> findAll();
}
