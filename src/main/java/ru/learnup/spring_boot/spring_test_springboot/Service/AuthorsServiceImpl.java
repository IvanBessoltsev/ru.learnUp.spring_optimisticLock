package ru.learnup.spring_boot.spring_test_springboot.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.learnup.spring_boot.spring_test_springboot.entity.Authors;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.repository.AuthorsRepository;
import ru.learnup.spring_boot.spring_test_springboot.repository.BooksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsServiceImpl implements AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;


    @Override
    public List<Authors> getAllAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors getAuthorsById(int id) {
        Authors author = null;
        Optional<Authors> a = authorsRepository.findById(id);
        if (a.isPresent()) {
            author = a.get();
        }
        return author;
    }

    @Override
    public void saveAuthors(Authors authors) {
        authorsRepository.save(authors);
    }

    @Override
    public void deleteAuthor(int id) {
        authorsRepository.deleteById(id);
    }
}
