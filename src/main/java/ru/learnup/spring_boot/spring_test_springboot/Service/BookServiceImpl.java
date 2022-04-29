package ru.learnup.spring_boot.spring_test_springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import ru.learnup.spring_boot.spring_test_springboot.entity.Book;
import ru.learnup.spring_boot.spring_test_springboot.entity.Client;
import ru.learnup.spring_boot.spring_test_springboot.entity.Order;
import ru.learnup.spring_boot.spring_test_springboot.repository.BooksRepository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BooksRepository bookRepository;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        Optional<Book> b = bookRepository.findById(id);
        if (b.isPresent()) {
            book = b.get();
        }
        return book;
    }

    @Override
    @Transactional
      public void saveBook(Book book) {
        bookRepository.save(book);

    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }





}