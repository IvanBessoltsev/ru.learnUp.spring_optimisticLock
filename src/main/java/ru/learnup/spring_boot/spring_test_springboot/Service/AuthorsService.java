package ru.learnup.spring_boot.spring_test_springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.learnup.spring_boot.spring_test_springboot.entity.Authors;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.repository.AuthorsRepository;

import java.util.List;

public interface AuthorsService {


    public List<Authors> getAllAuthors();

    public Authors getAuthorsById(int id);

    public void saveAuthors(Authors authors);

    public void deleteAuthor(int id);

}
