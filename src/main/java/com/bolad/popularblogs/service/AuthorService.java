package com.bolad.popularblogs.service;

import com.bolad.popularblogs.domain.Author;
import com.bolad.popularblogs.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        super();
        this.authorRepository = authorRepository;
    }

    public List<Author> listOfAuthors() {
        return authorRepository.findAllByOrOrderByLastNameAscFirstNameAsc();
    }

}
