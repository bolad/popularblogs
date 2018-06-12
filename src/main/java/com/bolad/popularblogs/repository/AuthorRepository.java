package com.bolad.popularblogs.repository;

import com.bolad.popularblogs.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long > {

    List<Author> findAllByOrOrderByLastNameAscFirstNameAsc();
}
