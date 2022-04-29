package ru.learnup.spring_boot.spring_test_springboot.Service;


import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.entity.Client;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public Book getBookById(int id);

    public void saveBook(Book book);

    public void deleteBook(int id);


}
